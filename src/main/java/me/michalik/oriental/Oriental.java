package me.michalik.oriental;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.id.ORID;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import me.michalik.oriental.actions.MapODocument;

public class Oriental {

    private final OrientGraphFactory orientGraphFactory;
    
    public Oriental(OrientalProperties orientalProperties){
        this.orientGraphFactory = new OrientGraphFactory(orientalProperties.getUrl(), orientalProperties.getUser(), orientalProperties.getPassword());
        orientGraphFactory.setupPool(orientalProperties.getMinPool(), orientalProperties.getMaxPool());
        orientGraphFactory.setAutoStartTx(orientalProperties.getAutoStartTx());
        orientGraphFactory.setRequireTransaction(orientalProperties.getRequireTransaction());
        orientGraphFactory.setKeepInMemoryReferences(orientalProperties.getKeepInMemoryReference());
        orientGraphFactory.setMaxRetries(orientalProperties.getMaxRetries());
    }


    // TODO - tu chce mieć typ zwraca T
    public Object findById(ORID orid, MapODocument mapODocument) throws Exception {
        ODatabaseDocumentTx oDatabaseDocumentTx = this.orientGraphFactory.getDatabase();
        try{
            ODocument oDocument = oDatabaseDocumentTx.load(orid);
            return mapODocument.mapDocument(oDocument, oDatabaseDocumentTx);
        }catch (Exception e){
            throw e;
        }finally {
            oDatabaseDocumentTx.close();
        }
    }

}