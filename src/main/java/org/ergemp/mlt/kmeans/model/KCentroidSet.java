package org.ergemp.mlt.kmeans.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KCentroidSet {
    private List<KCentroid> KCentroids;

    public KCentroidSet(){ KCentroids = new ArrayList<>(); }
    public KCentroidSet(List<KCentroid> gKCentroidList){ KCentroids = gKCentroidList; }

    public List<KCentroid> getKCentroids() {
        return KCentroids;
    }

    public void setKCentroids(List<KCentroid> KCentroids) {
        this.KCentroids = KCentroids;
    }

    public void addKCentroid(KCentroid gKCentroid) {
        this.KCentroids.add(gKCentroid);
    }

    @Override
    public String toString() {
        String retVal = "";
        Iterator it = KCentroids.iterator();

        while (it.hasNext()){
            KCentroid centroid = (KCentroid)it.next();
            retVal +=  centroid.toString() + "\n";

        }
        return retVal;
    }

}
