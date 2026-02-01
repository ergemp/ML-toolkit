package org.ergemp.mlt.imageOperations.util;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;

public class PerformFFT2 {
    public static Complex[][] perform(int[][] gImage){


        Complex[][] complexImage = new Complex[gImage.length][gImage.length];

        for (int y = 0; y < gImage.length; y++) {
            for (int x = 0; x < gImage.length; x++) {
                complexImage[y][x] = new Complex(gImage[y][x], 0);
            }
        }

        // first fourier transform
        // fourier transform each row of the image
        // put the results in 2D array
        Complex[][] rowFFTResult = new Complex[gImage.length][gImage.length];

        for (Integer i=0; i<gImage.length; i++) {
            //
            FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);
            Complex[] fourierTransform = transformer
                    .transform(
                            complexImage[i],
                            TransformType.FORWARD);

            rowFFTResult[i] = fourierTransform;
        }

        Complex[][] transposedRowFFTResult = Transpose2DComplexArray.transpose(rowFFTResult);

        Complex[][] colFFTResult = new Complex[transposedRowFFTResult.length][transposedRowFFTResult.length];

        // now the second fourier transform
        // fourier transform each column of the image
        // put the results in 2D array
        for (Integer i=0; i<transposedRowFFTResult.length; i++) {

            //
            FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);
            Complex[] fourierTransform = transformer
                    .transform(
                            PadToPowerOfTwo.padLower(transposedRowFFTResult[i]),
                            TransformType.FORWARD);

            colFFTResult[i] = fourierTransform;
        }

        //transpose back to original
        Complex[][] colFFTResultBack2Original = Transpose2DComplexArray.transpose(colFFTResult);

        return colFFTResultBack2Original;

    }

}
