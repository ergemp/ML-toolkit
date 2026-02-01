package org.ergemp.mlt.sentiment.util;

public class DeleteFile {
    public static void delete(String gPath){
        try {
            java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get(gPath));
        }
        catch(Exception Ex) {
            System.out.println(Ex);
        }
    }
}
