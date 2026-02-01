package org.ergemp.mlt.kmeans.actor;

import org.ergemp.mlt.kmeans.model.KCentroid;
import org.ergemp.mlt.kmeans.model.KCentroidSet;
import org.ergemp.mlt.kmeans.model.KData;

public class ClosestCentroid {
    public static Integer calculate(KCentroidSet gKCentroidSet, KData gKData){

        double minDistance = Double.MAX_VALUE;
        int closestCentroidId = -1;

        // check all cluster centers
        for (KCentroid centroid : gKCentroidSet.getKCentroids()) {
            // compute distance
            double distance = gKData.euclideanDistance(centroid);

            // update nearest cluster if necessary
            if (distance < minDistance) {
                minDistance = distance;
                closestCentroidId = centroid.id;
            }
        }
        return closestCentroidId;
    }
}
