package com.dalcim.pizza.domain

data class Client(
    val id: Int = 0,
    val name: String,
    val address: String = ""
)