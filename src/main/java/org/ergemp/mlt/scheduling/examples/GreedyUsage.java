package org.ergemp.mlt.scheduling.examples;

import org.ergemp.mlt.scheduling.model.JobModel;
import org.ergemp.mlt.scheduling.model.Jobs;

public class GreedyUsage {
    public static void main(String[] args) {
        Integer processingArr[] = {64,25,12,22,11,5,4,9,10,2,3,7,6};
        Jobs myJobs = new Jobs();

        for (Integer i=0; i<processingArr.length; i++){
            JobModel job = new JobModel();
            job.setJobName("job" + processingArr[i]);
            job.setProcessingTime(Long.parseLong(processingArr[i].toString()));
            myJobs.addJob(job);
        }
    }
}
