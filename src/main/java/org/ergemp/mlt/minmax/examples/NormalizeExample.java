package org.ergemp.mlt.minmax.examples;

import org.ergemp.mlt.minmax.algorithm.MinMaxNormalization;

import java.util.ArrayList;

import java.util.List;

public class NormalizeExample {
    public static void main(String[] args) {

        List<Double> tt = new ArrayList<>();
        tt.add(0.0);
        tt.add(13.4);
        tt.add(9.1);
        tt.add(1.4);
        tt.add(0.4);
        tt.add(20.9);

        List<Double> normalizedtt = MinMaxNormalization.normalize(tt);

        System.out.println(normalizedtt.toString());

    }
}
