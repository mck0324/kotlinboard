package com.example.kotlinboard.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class UserResponse (
    var result:Result?=null,
    var description:String?=null,
    @JsonProperty(value = "user")
    var userRequest: MutableList<UserRequest>?=null
)
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class Result (
        @JsonProperty("result_code")
        var resultCode:String?=null,
        @JsonProperty("result_message")
        var resultMessage:String?=null,
)