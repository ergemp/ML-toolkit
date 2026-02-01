package org.ergemp.mlt.linearRegression.model;

public class RegressionModel {
    private double a;
    private double b;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public RegressionModel(Double a, Double b){
        this.a = a;
        this.b = b;
    }

    public Double getY (Double gX) {
        return (this.a + (this.b * gX));
    }
}
