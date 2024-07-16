package com.nhnacademy.batch.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScheduleTask {
	private final JobLauncher jobLauncher;
	private final Job job1;
	private final Job job2;

	// //@Scheduled(cron = "0 0 0 * * ?")
	// @Scheduled(fixedDelay = 1000 * 60 * 2)
	// public void reportCurrentTime() {
	// 	try {
	// 		JobParameters jobParameters = new JobParametersBuilder()
	// 			.addLong("time", System.currentTimeMillis())
	// 			.toJobParameters();
	// 		jobLauncher.run(job1, jobParameters);
	// 	} catch (Exception e) {
	// 		log.error(e.getMessage());
	// 	}
	// }
	//
	// @Scheduled(fixedDelay = 1000 * 60 * 2)
	// public void runMemberLevelUpgradeJob() {
	// 	try {
	// 		JobParameters jobParameters = new JobParametersBuilder()
	// 			.addLong("time", System.currentTimeMillis())
	// 			.toJobParameters();
	// 		jobLauncher.run(job2, jobParameters);
	// 	} catch (Exception e) {
	// 		log.error(e.getMessage());
	// 	}
	// }

}
