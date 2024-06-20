package com.nhnacademy.batch.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;
    //@Scheduled(cron = "0 0 0 * * ?")
    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTime(){
        try{
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(job, jobParameters);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
