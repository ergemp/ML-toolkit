package org.ergemp.mlt.kmeans.actor;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.ergemp.mlt.kmeans.model.KCentroid;
import org.ergemp.mlt.kmeans.model.KCentroidSet;
import org.ergemp.mlt.kmeans.model.KData;
import org.ergemp.mlt.kmeans.model.KDataSet;

import java.util.*;

public class RecalibrateKCentroidSet {
    public static KCentroidSet recalibrate(KCentroidSet gKCentroidSet, KDataSet gKDataSet, Integer iteration) {
        Multimap<Integer, KData> segMultiMapper = ArrayListMultimap.create();
        KCentroidSet retCentroidSet = gKCentroidSet;

        while (iteration > 0) {
            segMultiMapper.clear();

            Iterator it = gKDataSet.getKDataSet().iterator();
            while (it.hasNext()) {
                KData data = (KData) it.next();
                Integer seg = ClosestCentroid.calculate(retCentroidSet, data);

                segMultiMapper.put(seg, data);
            }

            /*
            for (Map.Entry entry : segMultiMapper.entries()) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
            }

            for (Collection collection : segMultiMapper.asMap().values()) {
                System.out.println(collection);
            }

            segMultiMapper.asMap().forEach(
                    (k,v) -> System.out.println("Key = " + k + ", Value = " + v));
            */

            List<KCentroid> centroidList = new ArrayList<>();

            Set<Integer> keys = segMultiMapper.keySet();
            for (Integer keyprint : keys) {

                KCentroid tmpCentroid = new KCentroid();
                tmpCentroid.id = keyprint;
                //System.out.println("Key = " + keyprint);

                Integer cnt = 0;
                Collection<KData> values = segMultiMapper.get(keyprint);
                for (KData value : values) {
                    //System.out.println("Value= " + value);

                    tmpCentroid.setD1(tmpCentroid.getD1() + value.getD1());
                    tmpCentroid.setD2(tmpCentroid.getD2() + value.getD2());
                    cnt++;
                }

                tmpCentroid.setD1(tmpCentroid.getD1()/cnt);
                tmpCentroid.setD2(tmpCentroid.getD2()/cnt);

                centroidList.add(tmpCentroid);

            }
            retCentroidSet.setKCentroids(centroidList);
            iteration--;
        }
        return retCentroidSet;
    }
}
