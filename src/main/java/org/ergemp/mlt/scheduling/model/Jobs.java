package org.ergemp.mlt.scheduling.model;

import java.util.List;

public class Jobs {
    private List<JobModel> jobList;

    public List<JobModel> getJobList() {
        return jobList;
    }

    public void setJobList(List<JobModel> jobList) {
        this.jobList = jobList;
    }

    public void addJob(JobModel gJob) {
        jobList.add(gJob);
    }
}
