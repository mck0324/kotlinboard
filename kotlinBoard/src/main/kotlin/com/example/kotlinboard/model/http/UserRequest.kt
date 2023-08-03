package com.example.kotlinboard.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest (
        var name:String?= null,
        var age:Int ?= null,
        var email:String?= null,
        var address:String?= null,
//        var phoneNumber:String?= null, //restapi는 보통 스네이크식으로 phone_number로 함 이렇게하면 안되므로
//        @JsonProperty("phone_number")
        var phoneNumber:String?= null
        //이렇게해도 되지만 회사마다 정책이 다다르고 매번 이렇게 해줄 수 없기에
        //@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)를 이용

)