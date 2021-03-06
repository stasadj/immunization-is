package com.immunization.common.dao;

import com.immunization.common.repository.Exist;

import java.util.List;
import java.util.Optional;

public abstract class DocumentDAO<T> {
    protected final Exist exist;
    private final Class<T> typeParameterClass;

    protected DocumentDAO(Exist exist, Class<T> typeParameterClass) {
        this.exist = exist;
        this.typeParameterClass = typeParameterClass;
    }

    public List<T> getByUsername(String username) throws Exception {
        throw new Exception("Not implemented");
    }

    public String save(String documentId, T document) throws Exception {
        return exist.save(documentId, document);
    }

    public String getXML(String documentId) throws Exception {
        return exist.retrieveRawXmlById(documentId, typeParameterClass);
    }

    public Optional<T> retrieveById(String documentId) throws Exception {
        throw new Exception("Not implemented");
    }
}
