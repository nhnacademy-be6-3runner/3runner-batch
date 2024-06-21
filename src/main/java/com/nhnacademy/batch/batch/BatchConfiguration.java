package com.nhnacademy.batch.batch;

import com.nhnacademy.batch.entity.member.Member;
import com.nhnacademy.batch.entity.member.enums.Status;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Configuration
public class BatchConfiguration {
    private final EntityManagerFactory entityManagerFactory;
    private final PlatformTransactionManager transactionManager;
    @Bean
    public Job job(JobRepository jobRepository, Step step){
        return new JobBuilder("simpleJob", jobRepository).start(step).build();
    }
    @Bean
    public Step read_akstep(JobRepository jobRepository){
        return new StepBuilder("step", jobRepository)
                .<Member, Member>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
    @Bean
    public JpaPagingItemReader<Member> reader(){
        return new JpaPagingItemReaderBuilder<Member>()
                .name("jpapagingreader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT m FROM Member m ORDER BY m.id ASC")
                .build();
    }
    @Bean
    public ItemProcessor<Member, Member> processor(){
        return (member-> {
            ZonedDateTime now = ZonedDateTime.now();
            if(member.getStatus()==Status.Withdrawn){
                return member;
            }
            long yearsDifference = ChronoUnit.YEARS.between(now, member.getLast_login_date());
            if(yearsDifference >= 1){
                member.setStatus(Status.Inactive);
                return member;
            }else{
                return member;
            }
        });
    }
    @Bean
    public JpaItemWriter<Member> writer(){
        JpaItemWriter<Member> writer = new JpaItemWriter<Member>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return writer;
    }

}
