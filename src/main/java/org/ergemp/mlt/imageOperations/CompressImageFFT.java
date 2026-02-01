package org.ergemp.mlt.imageOperations;

import org.apache.commons.math3.complex.Complex;
import org.ergemp.mlt.imageOperations.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CompressImageFFT {
    public static void main(String[] args) throws IOException {

        // read image to bufferedImage
        BufferedImage bufferedImage = ImageIO.read(new File("resources/images/sample_2048×2048.bmp"));

        // convert rgb image to grayscale
        BufferedImage grayScaleImage = ConvertToGrayScale.convert(bufferedImage);

        // ref: https://stackoverflow.com/questions/1626735/how-can-i-display-a-bufferedimage-in-a-jframe
        JFrame frameGrayScale = new JFrame();
        frameGrayScale.setLayout(new GridLayout());
        frameGrayScale.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frameGrayScale.setVisible(true);
        frameGrayScale.setResizable(true);
        frameGrayScale.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameGrayScale.setSize(800, 600);

        JPanel imageGrayScale = new JPanel();
        imageGrayScale.setLayout(new GridLayout());
        imageGrayScale.setSize(800, 600);
        JLabel imageGrayScaleLabel =  new JLabel(new ImageIcon(grayScaleImage));
        imageGrayScale.add(imageGrayScaleLabel);

        JScrollPane scrollerGrayScale = new JScrollPane(imageGrayScale);

        frameGrayScale.add(scrollerGrayScale);
        frameGrayScale.pack();

        // read the red pixels of the grayscale image
        // since this is a grayscale image all the color pixels are the same anyway.
        int GrayScaleImagePixels[][] = GetColorMatrix.getMatrixOfImage(grayScaleImage, GetColorMatrix.color.red);

        // perform fft2
        // rows and cols
        Complex[][] fft2Result = PerformFFT2.perform(GrayScaleImagePixels);

        // convert fft2 result to single dimension
        Complex[] rowFFTResult21D = Convert2DArrayTo1DArray.convert(fft2Result);

        // convert complex array to magnitude array
        Double[] rowFFTResult21DMagnitudeArray = Convert1DComplexArray2MagnitudeArray.convert(rowFFTResult21D);

        // get the largest 5% of the magnitude array
        // total image is (2048*2048)*0.05=209715
        Double threshold = GetLargestN.KthLargest(rowFFTResult21DMagnitudeArray, 200000);

        // generate compress image
        Complex[][] compressedImage = new Complex[fft2Result.length][fft2Result.length];

        // if the frequency mean of the fft2 result is smaller than the 5%th largest than 0
        // else take the frequency mean as is
        for (Integer i=0; i<fft2Result.length; i++ ){
            for (Integer j=0; j< fft2Result[0].length; j++){

                if ((fft2Result[i][j].getReal()*fft2Result[i][j].getReal()) +
                    (fft2Result[i][j].getImaginary()*fft2Result[i][j].getImaginary())
                    < threshold) {
                    compressedImage[i][j] = new Complex(0,0);
                }
                else {
                    compressedImage[i][j] = fft2Result[i][j];
                }
            }
        }

        // now inverse fft2 to regenerate the image
        Complex[][] compressedImageIFFT = PerformIFFT2.perform(compressedImage);
        int[][] compressedImagePixels = ConvertComplex2Pixels.convert(compressedImageIFFT);

        // create the buffered image from the ifft2
        BufferedImage returnImage = new BufferedImage(compressedImageIFFT.length,
                compressedImageIFFT.length,
                BufferedImage.TYPE_INT_ARGB);

        // set the rgb of the created image
        for (int i = 0; i < compressedImagePixels.length; i++) {
            for (int j = 0; j < compressedImagePixels.length; j++) {
                try {
                    Color color = new Color(compressedImagePixels[i][j], compressedImagePixels[i][j], compressedImagePixels[i][j]);
                    returnImage.setRGB(i, j, color.getRGB());
                }
                catch (Exception ex) {
                }
            }
        }

        // show the compressed image
        JFrame frameResult = new JFrame();
        frameResult.setLayout(new GridLayout());
        frameResult.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frameResult.setVisible(true);
        frameResult.setResizable(true);
        frameResult.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameResult.setSize(800, 600);

        JPanel imageResult = new JPanel();
        imageResult.setLayout(new GridLayout());
        imageResult.setSize(800, 600);
        JLabel imageLabel =  new JLabel(new ImageIcon(returnImage));
        imageResult.add(imageLabel);

        JScrollPane scrollerResult = new JScrollPane(imageResult);

        frameResult.add(scrollerResult);
        frameResult.pack();

        /*
        *
        // save the filtered image
        File outputfile = new File("data/saved.png");
        ImageIO.write(img, "png", outputfile);
        *
        * */

        System.out.println("end");
    }
}
