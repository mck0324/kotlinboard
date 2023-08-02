package com.example.kotlinboard.model.http

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class UserResponse (

)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class Result (
    var resultCode:String?=null,
    var resultMessage:String?=null,
)