package org.ergemp.mlt.sentiment.model;

import java.util.ArrayList;
import java.util.List;

public class NamedFreqMatrix {

    //public static enum enum_gramName { UNIGRAM, BIGRAM, TRIGRAM};
    //public String className = "";
    //public enum_gramName gramName ;
    public String folderName = "reportName";

    public List<FreqMatrix> listUniFreqMatrix = new ArrayList();
    public List<FreqMatrix> listBiFreqMatrix = new ArrayList();;
    public List<FreqMatrix> listTriFreqMatrix = new ArrayList();;
}
