package org.ergemp.mlt.sentiment.sink;

import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;
import org.ergemp.mlt.sentiment.util.Config;
import org.ergemp.mlt.sentiment.util.DeleteFile;

import java.util.Iterator;
import java.util.Map;

public class SaveToFile {

    public static void save(NamedFreqMatrix gNamedFreqMatrix, String gFileName){
        //create a new file under the folderName folder
        java.io.File saveFile = new java.io.File(Config.folderName + "/" + gFileName);
        String newLine = "\r\n";
        String line = "";

        try {
            if (!saveFile.exists()) {
                saveFile.createNewFile();
            }
            else {
                DeleteFile.delete(saveFile.getAbsolutePath());
                saveFile.createNewFile();
            }

            java.io.FileWriter fw = new java.io.FileWriter(saveFile, false);

            //write the unigrams
            for (Integer c=0; c < gNamedFreqMatrix.listUniFreqMatrix.size() ; c++) {
                line = "";

                Iterator it = gNamedFreqMatrix.listUniFreqMatrix.get(c).freq.entrySet().iterator() ;

                line += gNamedFreqMatrix.listUniFreqMatrix.get(c).word ;

                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    line += "$" + pair.getKey() + "=" + pair.getValue();
                    //it.remove();
                }
                fw.write(line);
                fw.write(newLine);
            }

            //write the bigrams
            for (Integer c=0; c < gNamedFreqMatrix.listBiFreqMatrix.size() ; c++) {
                line = "";

                Iterator it = gNamedFreqMatrix.listBiFreqMatrix.get(c).freq.entrySet().iterator() ;

                line += gNamedFreqMatrix.listBiFreqMatrix.get(c).word ;

                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    line += "$" + pair.getKey() + "=" + pair.getValue();
                    //it.remove();
                }
                fw.write(line);
                fw.write(newLine);
            }

            //write the trigrams
            for (Integer c=0; c < gNamedFreqMatrix.listTriFreqMatrix.size() ; c++) {
                line = "";

                Iterator it = gNamedFreqMatrix.listTriFreqMatrix.get(c).freq.entrySet().iterator() ;

                line += gNamedFreqMatrix.listTriFreqMatrix.get(c).word ;

                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    line += "$" + pair.getKey() + "=" + pair.getValue();
                    //it.remove();
                }

                fw.write(line);
                fw.write(newLine);
            }
            fw.flush();
            fw.close();
        }
        catch (Exception Ex) {
            System.out.println(Ex);
        }
    }
}
