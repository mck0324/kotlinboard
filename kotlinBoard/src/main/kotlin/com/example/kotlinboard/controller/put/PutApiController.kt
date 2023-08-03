package com.example.kotlinboard.controller.put

import com.example.kotlinboard.model.http.Result
import com.example.kotlinboard.model.http.UserRequest
import com.example.kotlinboard.model.http.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/api")
//PUT은 데이터가 없으면 만들고 있으면 수정
class PutApiController {
    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return  "put-mapping"
    }
    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping - put method"
    }
    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {
        //0.response
        return UserResponse().apply {
            //1. result
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            //2. description
            this.description = "so hot day"
        }.apply {
            //3.user
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name = "A"
                this.age = 10
                this.email = "dnddnd@dndndn"
                this.address = "Cal"
                this.phoneNumber = "11111"
            })
            userList.add(UserRequest().apply {
                this.name = "b"
                this.age = 20
                this.email = "hhhhd@dndndn"
                this.address = "NewYork"
                this.phoneNumber = "11111"
            })
            this.userRequest = userList

        }

    }
}