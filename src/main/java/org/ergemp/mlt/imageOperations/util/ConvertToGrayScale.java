package org.ergemp.mlt.imageOperations.util;

import java.awt.image.BufferedImage;

public class ConvertToGrayScale {
    public static BufferedImage convert(BufferedImage img){

        // ref: https://www.geeksforgeeks.org/java/image-processing-in-java-colored-image-to-grayscale-image-conversion/

        // get image's width and height
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage returnImage = new BufferedImage(img.getWidth(),
                img.getHeight(),
                BufferedImage.TYPE_INT_ARGB);

        int[] pixels = img.getRGB(0, 0, width, height, null, 0, width);
        // convert to grayscale
        for (int i = 0; i < pixels.length; i++) {

            // Here i denotes the index of array of pixels
            // for modifying the pixel value.
            int p = pixels[i];

            int a = (p >> 24) & 0xff;
            int r = (p >> 16) & 0xff;
            int g = (p >> 8) & 0xff;
            int b = p & 0xff;

            // calculate average
            int avg = (r + g + b) / 3;

            // replace RGB value with avg
            p = (a << 24) | (avg << 16) | (avg << 8) | avg;

            pixels[i] = p;
        }
        returnImage.setRGB(0, 0, width, height, pixels, 0, width);

        return returnImage;
    }
}
