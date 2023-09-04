package com.batch02

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Batch02Application

fun main(args: Array<String>) {
    runApplication<Batch02Application>(*args)
}
