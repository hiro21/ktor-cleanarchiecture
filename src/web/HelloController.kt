package com.example.web

interface HelloController {
    fun fetch(): String
}
class HelloControllerImpl : HelloController {
    override fun fetch(): String {
        return "hello!"
    }
}