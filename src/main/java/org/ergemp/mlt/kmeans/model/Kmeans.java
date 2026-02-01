package org.ergemp.mlt.kmeans.model;

import java.util.ArrayList;
import java.util.List;

public class Kmeans {
    public List<Double[]> observationSet = new ArrayList();
    public List<String> labelSet = new ArrayList();
    public List<Double[]> centroids = new ArrayList();
    public String[] clusterLabels = {"cluster1","cluster2","cluster3","cluster4"};

    public boolean clearObservation() {
        Boolean retVal=true;
        try {
            this.observationSet.clear();
            retVal = true;
        }
        catch(Exception Ex) {
            retVal = false;
        }
        finally {
            return retVal;
        }
    }

    public boolean clearCentroids() {
        Boolean retVal=true;
        try {
            this.centroids.clear();
            retVal = true;
        }
        catch(Exception Ex) {
            retVal = false;
        }
        finally {
            return retVal;
        }
    }
}
