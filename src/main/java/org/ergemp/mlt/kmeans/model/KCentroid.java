package org.ergemp.mlt.kmeans.model;

public class KCentroid extends KData {
    public int id;

    public KCentroid() { super(0.0, 0.0); }

    public KCentroid(int id, double x, double y) {
        super(x, y);
        this.id = id;
    }

    public KCentroid(int id, KData p) {
        super(p.getD1(), p.getD2());
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " - " + super.toString();
    }
}
