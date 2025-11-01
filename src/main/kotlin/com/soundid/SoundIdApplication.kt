package com.soundid

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SoundIdApplication

fun main(args: Array<String>) {
    runApplication<SoundIdApplication>(*args)
}