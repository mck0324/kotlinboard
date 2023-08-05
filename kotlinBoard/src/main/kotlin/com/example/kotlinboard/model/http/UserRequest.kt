package com.example.kotlinboard.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.PositiveOrZero
import jakarta.validation.constraints.Size
import java.time.LocalDateTime
import java.time.LocalDateTime.parse
import java.time.format.DateTimeFormatter
import kotlin.math.min

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest (

        @field:NotEmpty
        @field:Size(min = 2, max = 8)
        var name:String?= null,

        @field:PositiveOrZero // 0 보다 큰 숫자 검사 (0포함)
        var age:Int ?= null,

        @field:Email //이메일 양식
        var email:String?= null,

        @field:NotBlank // 공백 검증
        var address:String?= null,
//        var phoneNumber:String?= null, //restapi는 보통 스네이크식으로 phone_number로 함 이렇게하면 안되므로
//        @JsonProperty("phone_number")
        @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$") //정규식 검증
        var phoneNumber:String?= null,
        //이렇게해도 되지만 회사마다 정책이 다다르고 매번 이렇게 해줄 수 없기에
        //@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)를 이용

        var createdAt:String?=null //yyyy-MM-dd HH:mm:ss ex)2020-10-12 13:00:00

){
        @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 여야 합니다")
        private fun isValidCreatedAt():Boolean{ //정상true, 비정상 false
                return try {
                    parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                        true
                } catch (e:Exception) {
                        false
                }
        }
}