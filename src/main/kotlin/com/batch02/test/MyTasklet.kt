package com.batch02.test

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@StepScope
class MyTasklet() : Tasklet {

    //private val logger: Logger = LoggerFactory.getLogger( "MyTasklet")

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {

      println(">>>>>>>>>" +  contribution.readCount)
        return RepeatStatus.FINISHED
    }
}