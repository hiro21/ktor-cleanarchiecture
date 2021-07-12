package com.example

import com.example.usecase.HelloInteractor
import com.example.usecase.HelloUsecase
import com.example.web.HelloController
import com.example.web.HelloControllerImpl
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.dsl.module
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    // setting DI
    install(Koin) {
        // modulesを設定する。ここに追加したいものを追加する
        modules(helloModule)
    }

    // inject
    val helloController: HelloController by inject()

    routing {
        get("/test") {
            call.apply {
                respond("helloTest")
            }
        }
        get("/hello") {
            call.respondText(helloController.fetch())
        }
    }
}

// DIの設定
val helloModule = module {
    single<HelloController> { HelloControllerImpl(get()) }
    single<HelloUsecase> { HelloInteractor() }
}

