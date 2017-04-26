package me.michalik.oriental.usage;

import com.orientechnologies.orient.core.id.ORecordId;
import me.michalik.oriental.Oriental;
import me.michalik.oriental.OrientalProperties;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        OrientalProperties orientalProperties = new OrientalProperties();

        Oriental oriental = new Oriental(orientalProperties);

        // TODO - jak to zrobić bez castowania?
        Map<String, Object> a = (Map<String, Object>) oriental.findById(new ORecordId(12, 12), (document, databaseDocumentTx) -> document.toMap());


    }

}
