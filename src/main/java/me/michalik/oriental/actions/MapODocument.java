package me.michalik.oriental.actions;


import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

public interface MapODocument<T> {

    T mapDocument(ODocument document, ODatabaseDocumentTx databaseDocumentTx);

}