package org.ergemp.mlt.kmeans.actor;

import org.ergemp.mlt.kmeans.model.Kmeans;

public class InitializeCentroids {
    public static void initialize(Kmeans gKmeans, Integer gK) {
        Double tmpCentroid = Double.parseDouble("0");
        Double avgCentroid = Double.parseDouble("0");
        Integer centroidIndex = 0;

        try {
            if (gK > gKmeans.observationSet.size()) {
                throw new Exception("initalizeCentroids: there is not enough observation for this cluster");
            }

            for (Integer i=0; i<gK; i++) {
                tmpCentroid = Double.parseDouble("0");
                for (Integer j=(gKmeans.observationSet.size()/gK)*i; j<((gKmeans.observationSet.size()/gK)*i)+(gKmeans.observationSet.size()/gK); j++) {
                    tmpCentroid += gKmeans.observationSet.get(j)[0];
                }
                avgCentroid = tmpCentroid/(gKmeans.observationSet.size()/gK);

                tmpCentroid = Double.parseDouble("0");
                for (Integer j=(gKmeans.observationSet.size()/gK)*i; j<((gKmeans.observationSet.size()/gK)*i)+(gKmeans.observationSet.size()/gK); j++) {
                    if ((java.lang.Math.abs(gKmeans.observationSet.get(j)[0] - avgCentroid)) < (java.lang.Math.abs(tmpCentroid - avgCentroid)) ) {
                        tmpCentroid = gKmeans.observationSet.get(j)[0];
                        centroidIndex = j;
                    }
                }
                gKmeans.centroids.add(gKmeans.observationSet.get(centroidIndex));
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
        }
    }
}
