package org.ergemp.mlt.pearsonsCorrelation.actor;

import java.util.List;

public class Calculator {
    public static Double calculate(List<Double> gArr1, List<Double> gArr2, Boolean debug){

        Double coeff = 0.0;

        Double meanArr1;
        Double meanArr2;

        Double sumArr1Pow2 = 0.0;
        Double sumArr2Pow2 = 0.0;

        Double dividend = 0.0;
        Double divisor = 0.0;

        try {
            if (gArr1.size() != gArr2.size()) {
                throw new Exception("org.ergemp.mlt.pearsonsCorrelation.actor.Calculator.calculate: parameter sizes should match!.. ");
            }

            meanArr1 = getMean.get(gArr1, debug);
            meanArr2 = getMean.get(gArr2, debug);

            for (Integer i=0; i<gArr1.size(); i++){
                dividend = dividend + ((gArr1.get(i) - meanArr1) * (gArr2.get(i) - meanArr2));

                sumArr1Pow2 += Math.pow(gArr1.get(i) - meanArr1,2);
                sumArr2Pow2 += Math.pow(gArr2.get(i) - meanArr2,2);
            }
            divisor = Math.sqrt(sumArr1Pow2 * sumArr2Pow2);

            if (debug) {System.out.println(dividend + " / " + divisor);}
            coeff = dividend/divisor;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally{
            return coeff;
        }
    }
}
