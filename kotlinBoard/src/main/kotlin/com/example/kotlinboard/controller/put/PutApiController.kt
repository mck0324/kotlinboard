package com.example.kotlinboard.controller.put

import com.example.kotlinboard.model.http.UserRequest
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
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        return userRequest
    }
}