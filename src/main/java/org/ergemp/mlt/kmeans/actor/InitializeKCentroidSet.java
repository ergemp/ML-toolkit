package org.ergemp.mlt.kmeans.actor;

import org.ergemp.mlt.kmeans.model.KCentroid;
import org.ergemp.mlt.kmeans.model.KCentroidSet;
import org.ergemp.mlt.kmeans.model.KDataSet;

public class InitializeKCentroidSet {
    public static KCentroidSet initialize(KDataSet gKDataSet, Integer gK) {
        Double tmpCentroid = Double.parseDouble("0");
        Double avgCentroid = Double.parseDouble("0");
        Integer centroidIndex = 0;

        KCentroidSet centroids = new KCentroidSet();

        try {
            if (gK > gKDataSet.getSize()) {
                throw new Exception("initalizeCentroids: there is not enough observation for this cluster");
            }

            for (Integer i=0; i<gK; i++) {
                tmpCentroid = Double.parseDouble("0");
                for (Integer j=(gKDataSet.getSize()/gK)*i; j<((gKDataSet.getSize()/gK)*i)+(gKDataSet.getSize()/gK); j++) {
                    tmpCentroid += gKDataSet.getKDataSet().get(j).getD1();
                }
                avgCentroid = tmpCentroid/(gKDataSet.getSize()/gK);

                tmpCentroid = Double.parseDouble("0");
                for (Integer j=(gKDataSet.getSize()/gK)*i; j<((gKDataSet.getSize()/gK)*i)+(gKDataSet.getSize()/gK); j++) {
                    if ((Math.abs(gKDataSet.getKDataSet().get(j).getD1() - avgCentroid)) < (Math.abs(tmpCentroid - avgCentroid)) ) {
                        tmpCentroid = gKDataSet.getKDataSet().get(j).getD1();
                        centroidIndex = j;
                    }
                }
                centroids.addKCentroid(new KCentroid(centroidIndex, gKDataSet.getKDataSet().get(centroidIndex).getD1(), gKDataSet.getKDataSet().get(centroidIndex).getD2()));
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            return centroids;
        }
    }
}
