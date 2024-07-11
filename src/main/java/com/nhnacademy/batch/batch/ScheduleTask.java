package com.nhnacademy.batch.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ScheduleTask {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job1;
    @Autowired
    private Job job2;
    //@Scheduled(cron = "0 0 0 * * ?")
    @Scheduled(fixedDelay = 1000*60*2)
    public void reportCurrentTime(){
        try{
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(job1, jobParameters);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Scheduled(fixedDelay = 1000*60*2)
    public void runMemberLevelUpgradeJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
            jobLauncher.run(job2, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
