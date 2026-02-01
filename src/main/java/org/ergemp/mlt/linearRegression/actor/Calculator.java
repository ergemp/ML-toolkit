package org.ergemp.mlt.linearRegression.actor;

import org.ergemp.mlt.linearRegression.model.RegressionModel;

import java.util.List;

public class Calculator {
    public static RegressionModel calculate(List<Double> gArr1, List<Double> gArr2, Boolean debug){

        Double S1 = 0.0;
        Double S2 = 0.0;

        Double meanArr1 = org.ergemp.mlt.pearsonsCorrelation.actor.getMean.get(gArr1, false);
        Double meanArr2 = org.ergemp.mlt.pearsonsCorrelation.actor.getMean.get(gArr2, false);

        Double pearsonsCoeff =  org.ergemp.mlt.pearsonsCorrelation.actor.Calculator.calculate(gArr1, gArr2, false);

        for (Double l1 : gArr1) {
            S1 += Math.pow(l1-meanArr1,2) ;
        }

        S1 = Math.sqrt(S1/(gArr1.size()-1));

        for (Double l2 : gArr2) {
            S2 += Math.pow(l2-meanArr2,2) ;
        }

        S2 = Math.sqrt(S2/(gArr2.size()-1));

        Double b = pearsonsCoeff * (S2/S1);
        Double a = meanArr2 - (b*meanArr1);

        if (debug){
            System.out.println("S1: " + S1);
            System.out.println("S2: " + S2);
            System.out.println("pearsonsCoeff: " + pearsonsCoeff);

            System.out.println("b: " + b);
            System.out.println("a: " + a);
        }

        return (new RegressionModel(a,b));

    }
}
