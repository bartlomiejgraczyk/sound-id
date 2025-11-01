package com.soundid

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldEndpoint {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello, World!"
    }
}