package org.ergemp.mlt.imageOperations.util;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;

public class PerformIFFT2 {
    public static Complex[][] perform(Complex[][] complexImage){

        // first fourier transform
        // fourier transform each row of the image
        // put the results in 2D array
        Complex[][] rowFFTResult = new Complex[complexImage.length][complexImage.length];

        for (Integer i=0; i<complexImage.length; i++) {
            // convert integer array to double
            // apache.commons.math accepts double array

            //
            FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);
            Complex[] fourierTransform = transformer
                    .transform(
                            complexImage[i],
                            TransformType.INVERSE);

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
                            TransformType.INVERSE);

            colFFTResult[i] = fourierTransform;
        }

        //transpose back to original
        Complex[][] colFFTResultBack2Original = Transpose2DComplexArray.transpose(colFFTResult);
        return colFFTResultBack2Original;

    }
}
