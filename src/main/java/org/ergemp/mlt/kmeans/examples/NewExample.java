package org.ergemp.mlt.kmeans.examples;

import org.ergemp.mlt.kmeans.actor.ClosestCentroid;
import org.ergemp.mlt.kmeans.actor.InitializeKCentroidSet;
import org.ergemp.mlt.kmeans.actor.RecalibrateKCentroidSet;
import org.ergemp.mlt.kmeans.model.KCentroidSet;
import org.ergemp.mlt.kmeans.model.KData;
import org.ergemp.mlt.kmeans.model.KDataSet;

public class NewExample {
    public static void main(String[] args){

        KDataSet myMeans = new KDataSet();

        myMeans.addKData(new KData(10.5,2.5));
        myMeans.addKData(new KData(10.2,2.1));
        myMeans.addKData(new KData(12,2));
        myMeans.addKData(new KData(18,3));
        myMeans.addKData(new KData(25,4));
        myMeans.addKData(new KData(22,1));
        myMeans.addKData(new KData(27,2));
        myMeans.addKData(new KData(26,3));
        myMeans.addKData(new KData(11,5));
        myMeans.addKData(new KData(23,5));

        KCentroidSet centroids = InitializeKCentroidSet.initialize(myMeans,2);
        System.out.println(centroids.toString());

        Integer val = ClosestCentroid.calculate(centroids, new KData(20,1));
        System.out.println(val);

        KCentroidSet calibratedCentroids = RecalibrateKCentroidSet.recalibrate(centroids, myMeans, 5);
        System.out.println(calibratedCentroids.toString());

        Integer val2 = ClosestCentroid.calculate(calibratedCentroids, new KData(20,1));
        System.out.println(val2);
    }
}
