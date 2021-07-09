package com.example

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.Koin

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    // setting DI
    install(Koin) {

    }
    routing {
        get("/test") {
            call.apply {
                respond("helloTest")
            }
        }
    }
}

