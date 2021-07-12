package com.example.usecase

interface HelloUsecase {
    fun fetch(): String
}

class HelloInteractor : HelloUsecase{
    override fun fetch(): String {
        return "hello usecase result!"
    }
}