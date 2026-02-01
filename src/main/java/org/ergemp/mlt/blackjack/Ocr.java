package org.ergemp.mlt.blackjack;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class Ocr {
    public static void main(String[] args) {
        //File image = new File("resources/fox.png");
        File image = new File("resources/blackjack-test03.jpg");
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("resources/tessdata");
        //tesseract.setLanguage("eng");
        //tesseract.setPageSegMode(1);
        //tesseract.setOcrEngineMode(1);


        try {

            String result = tesseract.doOCR(image);
            System.out.println(result);

        } catch (TesseractException e) {
            throw new RuntimeException(e);
        }
    }
}
