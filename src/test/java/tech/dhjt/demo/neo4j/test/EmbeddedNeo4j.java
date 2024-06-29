package tech.dhjt.demo.neo4j.test;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class EmbeddedNeo4j {

    public static void main(String[] args) {
        String fileStoreUri = "file://tmp";
        try {
            URI uri = new URI(fileStoreUri);
            File file = new File(uri);
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
