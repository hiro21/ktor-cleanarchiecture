package com.example.web

import com.example.usecase.HelloUsecase

interface HelloController {
    fun fetch(): String
}
class HelloControllerImpl(
    val usecase: HelloUsecase
) : HelloController {
    override fun fetch(): String {
        val result = usecase.fetch()
        return result
    }
}