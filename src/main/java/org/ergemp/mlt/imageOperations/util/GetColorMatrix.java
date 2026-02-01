package org.ergemp.mlt.imageOperations.util;

import java.awt.image.BufferedImage;

public class GetColorMatrix {
    public static enum color {red, green, blue, alpha, other}

    public static int[][] getMatrixOfImage(BufferedImage bufferedImage, color gColor) {

        //
        // return the color values of the image
        //
        int width = bufferedImage.getWidth(null);
        int height = bufferedImage.getHeight(null);

        int[][] pixels = new int[width][height];
        int[][] redPixels = new int[width][height];
        int[][] greenPixels = new int[width][height];
        int[][] bluePixels = new int[width][height];
        int[][] alphaPixels = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixels[i][j] = bufferedImage.getRGB(i, j);
                redPixels[i][j] =  (pixels[i][j] & 0xff0000) >> 16;
                greenPixels[i][j] =  (pixels[i][j] & 0xff00) >> 8;
                bluePixels[i][j] =  pixels[i][j] & 0xff;
                alphaPixels[i][j] = (pixels[i][j] & 0xff000000) >>> 24;
            }
        }

        if (gColor.equals(color.red)){
            return redPixels;
        }
        else if (gColor.equals(color.green)) {
            return greenPixels;
        }
        else if (gColor.equals(color.blue)){
            return bluePixels;
        }
        else if (gColor.equals(color.alpha)){
            return alphaPixels;
        }
        else {
            return pixels;
        }
    }

}
