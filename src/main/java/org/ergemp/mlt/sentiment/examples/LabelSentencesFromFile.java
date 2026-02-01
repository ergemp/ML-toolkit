package org.ergemp.mlt.sentiment.examples;

import org.ergemp.mlt.sentiment.actor.Print;
import org.ergemp.mlt.sentiment.actor.label.LabelBi;
import org.ergemp.mlt.sentiment.actor.label.LabelTri;
import org.ergemp.mlt.sentiment.actor.label.LabelUni;
import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;
import org.ergemp.mlt.sentiment.sink.SaveToFile;
import org.ergemp.mlt.sentiment.util.Config;

public class LabelSentencesFromFile {
    public static void main(String[] args){
        NamedFreqMatrix matrix = new NamedFreqMatrix();

        java.io.File negativeFile = new java.io.File(Config.folderName + "/negative_en.txt");
        java.io.File positiveFile = new java.io.File(Config.folderName + "/positive_en.txt");
        java.io.FileReader fr;
        java.io.BufferedReader br;

        String line="";

        try {
            fr = new java.io.FileReader(negativeFile.getAbsolutePath());
            br = new java.io.BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                LabelUni.label(matrix, line,"negative");
                LabelBi.label(matrix, line,"negative");
                LabelTri.label(matrix, line,"negative");
            }

            fr = new java.io.FileReader(positiveFile.getAbsolutePath());
            br = new java.io.BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                LabelUni.label(matrix, line,"positive");
                LabelBi.label(matrix, line,"positive");
                LabelTri.label(matrix, line,"positive");
            }

            br.close();
            fr.close();

            Print.print(matrix);
            SaveToFile.save(matrix,"lexicon_pos_neg");
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
        }
    }
}
