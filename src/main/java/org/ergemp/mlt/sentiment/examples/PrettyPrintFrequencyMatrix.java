package org.ergemp.mlt.sentiment.examples;

import org.ergemp.mlt.sentiment.actor.Print;
import org.ergemp.mlt.sentiment.actor.label.LabelBi;
import org.ergemp.mlt.sentiment.actor.label.LabelTri;
import org.ergemp.mlt.sentiment.actor.label.LabelUni;
import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;

public class PrettyPrintFrequencyMatrix {
    public static void main(String[] args){
        NamedFreqMatrix matrix = new NamedFreqMatrix();

        LabelUni.label(matrix, "what the fuck","negative");
        LabelUni.label(matrix, "fuck you", "negative");
        LabelUni.label(matrix, "you are most welcome my friend", "positive");

        LabelBi.label(matrix, "what the fuck", "negative");
        LabelBi.label(matrix, "fuck you", "negative");
        LabelBi.label(matrix, "you are most welcome my friend", "positive");

        LabelTri.label(matrix, "what the fuck", "negative");
        LabelTri.label(matrix, "fuck you", "negative");
        LabelTri.label(matrix, "you are most welcome my friend", "positive");

        Print.print(matrix);
    }
}
