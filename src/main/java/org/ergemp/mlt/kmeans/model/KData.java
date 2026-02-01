package org.ergemp.mlt.kmeans.model;

public class KData {
    private Double d1;
    private Double d2;

    public Double getD1() {
        return d1;
    }

    public void setD1(Double d1) {
        this.d1 = d1;
    }

    public Double getD2() {
        return d2;
    }

    public void setD2(Double d2) {
        this.d2 = d2;
    }

    public KData(){}

    public KData(double x, double y) {
        this.d1 = x;
        this.d2 = y;
    }

    public double euclideanDistance(KData other) {
        return Math.sqrt((d1 - other.d1) * (d1 - other.d1) + (d2 - other.d2) * (d2 - other.d2));
    }

    public void clear() {
        d1 = d2 = 0.0;
    }

    @Override
    public String toString() {
        return d1 + " - " + d2;
    }
}
