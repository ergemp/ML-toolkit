package org.ergemp.mlt.sentiment.source;

import org.ergemp.mlt.sentiment.model.FreqMatrix;
import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;
import org.ergemp.mlt.sentiment.util.Config;

import java.util.HashMap;
import java.util.Map;

public class LoadFromFile {
    public static NamedFreqMatrix load(String gFileName){

        NamedFreqMatrix retMatrix = new NamedFreqMatrix();

        //i know where to read a file
        java.io.File loadFile = new java.io.File(Config.folderName + "/" + gFileName );
        String line="";

        try {
            if (!loadFile.exists()) {
                return null;
            }

            java.io.FileReader fr = new java.io.FileReader(loadFile.getAbsolutePath());
            java.io.BufferedReader br = new java.io.BufferedReader(fr);

            while ((line = br.readLine()) != null) {

                if (!line.trim().equalsIgnoreCase("")) {
                    String[] lineArr = line.split("\\$");

                    ///////////////
                    //fill uniGrams
                    ///////////////
                    if (lineArr[0].split(" ").length == 1) {
                        Map<String, Integer> tmpMap = new HashMap<>();
                        for (int i=1; i<lineArr.length; i++) {
                            tmpMap.put(lineArr[i].split("=")[0], Integer.parseInt(lineArr[i].split("=")[1]));
                        }
                        FreqMatrix tmpMatrix = new FreqMatrix(lineArr[0],tmpMap);
                        retMatrix.listUniFreqMatrix.add(tmpMatrix);
                    }
                    //////////////
                    //fill biGrams
                    //////////////
                    else if (lineArr[0].split(" ").length == 2) {
                        Map<String, Integer> tmpMap = new HashMap<>();
                        for (int i=1; i<lineArr.length; i++) {
                            tmpMap.put(lineArr[i].split("=")[0], Integer.parseInt(lineArr[i].split("=")[1]));
                        }
                        FreqMatrix tmpMatrix = new FreqMatrix(lineArr[0],tmpMap);
                        retMatrix.listBiFreqMatrix.add(tmpMatrix);
                    }
                    ///////////////
                    //fill triGrams
                    ///////////////
                    else if (lineArr[0].split(" ").length == 3) {
                        Map<String, Integer> tmpMap = new HashMap<>();
                        for (int i=1; i<lineArr.length; i++) {
                            tmpMap.put(lineArr[i].split("=")[0], Integer.parseInt(lineArr[i].split("=")[1]));
                        }
                        FreqMatrix tmpMatrix = new FreqMatrix(lineArr[0],tmpMap);
                        retMatrix.listTriFreqMatrix.add(tmpMatrix);
                    }
                }
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally{
            return retMatrix;
        }
    }
}