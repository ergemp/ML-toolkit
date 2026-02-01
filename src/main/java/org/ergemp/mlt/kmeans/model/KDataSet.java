package org.ergemp.mlt.kmeans.model;

import java.util.ArrayList;
import java.util.List;

public class KDataSet {
    private List<KData> KDataSet;

    public KDataSet(){
        KDataSet = new ArrayList<>();
    }

    public List<KData> getKDataSet() {
        return KDataSet;
    }

    public void setKDataSet(List<KData> KDataSet) {
        this.KDataSet = KDataSet;
    }

    public void addKData(KData gKData) { this.KDataSet.add(gKData); }

    public Integer getSize() { return KDataSet.size(); }
}
