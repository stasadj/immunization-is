package com.immunization.backend;

import java.io.File;

import org.exist.xmldb.EXistResource;
import org.xmldb.api.base.Collection;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;

import com.immunization.backend.util.AuthenticationUtilities;
import com.immunization.backend.util.AuthenticationUtilities.ConnectionProperties;

public class DatabaseStoringExample {
    
	private static ConnectionProperties conn;
	
    public static void main(String[] args) throws Exception {
		DatabaseStoringExample.run(conn = AuthenticationUtilities.loadProperties(), args);
	}
    
    /**
     * conn XML DB connection properties
     * args[0] Should be the collection ID to access
     * args[1] Should be the document ID to store in the collection
     * args[2] Should be the document file path  
     */
    public static void run(ConnectionProperties conn, String args[]) throws Exception {
       
    	System.out.println("[INFO] " + DatabaseStoringExample.class.getSimpleName());
    	
    	// initialize collection and document identifiers
        String collectionId = null;
		String documentId = null; 
		String filePath = null;
        
        if (args.length == 3) {
        	
        	System.out.println("[INFO] Passing the arguments... ");
        	
        	collectionId = args[0];
        	documentId = args[1];
        	
        	filePath = args[2];
        } else {
        	
        	System.out.println("[INFO] Using defaults.");
        	
        	collectionId = "/db/Team404/digitalni_sertifikat";
        	documentId = "ds.xml";
        	
        	filePath = "./src/main/resources/documents/digitalni_sertifikat.xml";
        	
        }

        System.out.println("\t- collection ID: " + collectionId);
    	System.out.println("\t- document ID: " + documentId);
    	System.out.println("\t- file path: " + filePath + "\n");
        
        // initialize database driver
    	System.out.println("[INFO] Loading driver class: " + conn.driver);
    	Class<?> cl = Class.forName(conn.driver);
        
        
        // encapsulation of the database driver functionality
    	Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");
        
        // entry point for the API which enables you to get the Collection reference
        DatabaseManager.registerDatabase(database);
        
        // a collection of Resources stored within an XML database
        Collection col = null;
        XMLResource res = null;
        
        try { 
        	
        	System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = getOrCreateCollection(collectionId);
            
            /*
             *  create new XMLResource with a given id
             *  an id is assigned to the new resource if left empty (null)
             */
            System.out.println("[INFO] Inserting the document: " + documentId);
            res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);
            
            File f = new File(filePath);
            
            if(!f.canRead()) {
                System.out.println("[ERROR] Cannot read the file: " + filePath);
                return;
            }
            
            res.setContent(f);
            System.out.println("[INFO] Storing the document: " + res.getId());
            
            col.storeResource(res);
            System.out.println("[INFO] Done.");
            
        } finally {
            
        	//don't forget to cleanup
            if(res != null) {
                try { 
                	((EXistResource)res).freeResources(); 
                } catch (XMLDBException xe) {
                	xe.printStackTrace();
                }
            }
            
            if(col != null) {
                try { 
                	col.close(); 
                } catch (XMLDBException xe) {
                	xe.printStackTrace();
                }
            }
        }
    }
    
    private static Collection getOrCreateCollection(String collectionUri) throws XMLDBException {
        return getOrCreateCollection(collectionUri, 0);
    }
    
    private static Collection getOrCreateCollection(String collectionUri, int pathSegmentOffset) throws XMLDBException {
        
        Collection col = DatabaseManager.getCollection(conn.uri + collectionUri, conn.user, conn.password);
        
        // create the collection if it does not exist
        if(col == null) {
        
         	if(collectionUri.startsWith("/")) {
                collectionUri = collectionUri.substring(1);
            }
            
        	String pathSegments[] = collectionUri.split("/");
            
        	if(pathSegments.length > 0) {
                StringBuilder path = new StringBuilder();
            
                for(int i = 0; i <= pathSegmentOffset; i++) {
                    path.append("/" + pathSegments[i]);
                }
                
                Collection startCol = DatabaseManager.getCollection(conn.uri + path, conn.user, conn.password);
                
                if (startCol == null) {
                	
                	// child collection does not exist
                    
                	String parentPath = path.substring(0, path.lastIndexOf("/"));
                    Collection parentCol = DatabaseManager.getCollection(conn.uri + parentPath, conn.user, conn.password);
                    
                    CollectionManagementService mgt = (CollectionManagementService) parentCol.getService("CollectionManagementService", "1.0");
                    
                    System.out.println("[INFO] Creating the collection: " + pathSegments[pathSegmentOffset]);
                    col = mgt.createCollection(pathSegments[pathSegmentOffset]);
                    
                    col.close();
                    parentCol.close();
                    
                } else {
                    startCol.close();
                }
            }
            return getOrCreateCollection(collectionUri, ++pathSegmentOffset);
        } else {
            return col;
        }
    }
}
