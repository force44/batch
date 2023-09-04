package com.batch02.test

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager


@Configuration
class BatchJobConfiguration{
    @Bean
    fun testTasklet(): Tasklet {
        return Tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->
            // 태스크 내용 todo
            RepeatStatus.FINISHED
        }
    }

    @Bean
    fun myStep(
        jobRepository : JobRepository
        , testTasklet : Tasklet
        , transactionManager: PlatformTransactionManager?
    ): Step {
        return StepBuilder("myStep", jobRepository)
            .tasklet(testTasklet, transactionManager!!) // or .chunk(chunkSize, transactionManager)
            .build()
    }


    @Bean
    fun myJob(jobRepository : JobRepository, step :Step): Job {
        return JobBuilder("myJob", jobRepository)
            .start(step)
            .build()
    }
}

