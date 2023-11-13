package com.example.redis_spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RedisSpringApplication

fun main(args: Array<String>) {
    runApplication<RedisSpringApplication>(*args)
}
