package com.immunization.common.repository;

import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.UnmarshallerService;
import com.immunization.common.util.AuthenticationUtilitiesExist.ConnectionProperties;
import org.exist.xmldb.EXistResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

import javax.xml.transform.OutputKeys;
import java.util.ArrayList;
import java.util.List;

@Component
public class Exist {
    @Autowired
    private ConnectionProperties conn;
    @Autowired
    private UnmarshallerService unmarshallerService;
    @Autowired
    private MarshallerService marshallerService;

    private final String basePath = "/db/Team404/";

    public Object retrieveById(String documentId, Class<?> documentClass) throws Exception {
        String collectionId = basePath + documentClass.getSimpleName();

        initDBDriver();
        Collection collection = null;
        XMLResource resource = null;

        try {
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            collection = DatabaseManager.getCollection(conn.uri + collectionId);
            if (collection == null) return null;
            collection.setProperty(OutputKeys.INDENT, "yes");

            System.out.println("[INFO] Retrieving the document: " + documentId);
            resource = (XMLResource) collection.getResource(documentId);

            if (resource == null) {
                System.out.println("[WARNING] Document '" + documentId + "' can not be found!");
            } else {
                System.out.println("[INFO] Showing the document as XML resource: ");
                System.out.println(resource.getContent());
                return unmarshallerService.unmarshal(resource.getContent().toString());
            }
        } finally {
            cleanUp(collection, resource);
        }
        return null;
    }

    public List<Object> retrieveAllDocuments(Class<?> documentClass) throws Exception {
        String collectionId = basePath + documentClass.getSimpleName();

        initDBDriver();
        Collection collection = null;
        XMLResource resource = null;
        List<Object> list = new ArrayList<>();

        try {
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            collection = DatabaseManager.getCollection(conn.uri + collectionId);
            if (collection == null) return list;
            collection.setProperty(OutputKeys.INDENT, "yes");

            for (String documentId : collection.listResources()) {
                resource = (XMLResource) collection.getResource(documentId);
                list.add(unmarshallerService.unmarshal(resource.getContent().toString()));
            }
        } finally {
            cleanUp(collection, resource);
        }
        return list;
    }

    public String save(Object object) throws Exception {
        return save(null, object);
    }

    public String save(String documentId, Object object) throws Exception {
        String collectionId = basePath + object.getClass().getSimpleName();

        initDBDriver();
        Collection collection = null;
        XMLResource resource = null;

        try {
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            collection = getOrCreateCollection(collectionId);

            resource = (XMLResource) collection.createResource(documentId, XMLResource.RESOURCE_TYPE);
            resource.setContent(marshallerService.marshal(object));

            System.out.println("[INFO] Storing the document: " + resource.getId()+"; "+resource.getDocumentId());
            collection.storeResource(resource);
            System.out.println("[INFO] Done.");
            return resource.getId();
        } finally {
            cleanUp(collection, resource);
        }
    }

    public List<Object> query(String xPathExp, Class<?> documentClass, String namespace, String prefix) throws Exception {
        String collectionId = basePath + documentClass.getSimpleName();

        initDBDriver();
        Collection collection = null;
        XMLResource resource = null;
        List<Object> list = new ArrayList<>();

        try {
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            collection = DatabaseManager.getCollection(conn.uri + collectionId);
            if (collection == null) return list;
            collection.setProperty(OutputKeys.INDENT, "yes");

            XPathQueryService xpathService = (XPathQueryService) collection.getService("XPathQueryService", "1.0");
            xpathService.setProperty("indent", "yes");
            xpathService.setNamespace(prefix, namespace);

            ResourceSet resourceSet = xpathService.query(xPathExp);
            ResourceIterator it = resourceSet.getIterator();

            while (it.hasMoreResources()) {
                resource = (XMLResource) it.nextResource();
                list.add(unmarshallerService.unmarshal(resource.getContent().toString()));
            }
        } finally {
            cleanUp(collection, resource);
        }
        return list;
    }
    
    public List<Object> query(String xPathExp, Class<?> documentClass) throws Exception {
        return query(xPathExp, documentClass, "", "");
    }


    private void initDBDriver() throws Exception {
        Database database = (Database) Class.forName(conn.driver).newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);
    }

    private Collection getOrCreateCollection(String collectionUri) throws XMLDBException {
        return getOrCreateCollection(collectionUri, 0);
    }

    private Collection getOrCreateCollection(String collectionUri, int pathSegmentOffset) throws XMLDBException {
        Collection collection = DatabaseManager.getCollection(conn.uri + collectionUri, conn.user, conn.password);
        if (collection != null) return collection;

        if (collectionUri.startsWith("/"))
            collectionUri = collectionUri.substring(1);

        String[] pathSegments = collectionUri.split("/");

        if (pathSegments.length > 0) {
            StringBuilder path = new StringBuilder();

            for (int i = 0; i <= pathSegmentOffset; i++)
                path.append("/").append(pathSegments[i]);

            Collection startCol = DatabaseManager.getCollection(conn.uri + path, conn.user, conn.password);

            if (startCol == null) {
                String parentPath = path.substring(0, path.lastIndexOf("/"));
                Collection parentCol = DatabaseManager.getCollection(conn.uri + parentPath, conn.user, conn.password);

                CollectionManagementService mgt = (CollectionManagementService) parentCol.getService("CollectionManagementService", "1.0");

                System.out.println("[INFO] Creating the collection: " + pathSegments[pathSegmentOffset]);
                collection = mgt.createCollection(pathSegments[pathSegmentOffset]);

                collection.close();
                parentCol.close();
            } else {
                startCol.close();
            }
        }
        return getOrCreateCollection(collectionUri, ++pathSegmentOffset);
    }

    private void cleanUp(Collection collection, XMLResource resource) {
        if (resource != null) {
            try {
                ((EXistResource) resource).freeResources();
            } catch (XMLDBException xe) {
                xe.printStackTrace();
            }
        }
        if (collection != null) {
            try {
                collection.close();
            } catch (XMLDBException xe) {
                xe.printStackTrace();
            }
        }
    }
}
