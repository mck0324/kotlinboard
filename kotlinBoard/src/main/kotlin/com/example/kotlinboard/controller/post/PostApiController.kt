package com.example.kotlinboard.controller.post

import com.example.kotlinboard.model.http.UserRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/api")
class PostApiController {
    //POST Body의 내용을 넣어서 보낼 수 있음
    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"
    }

    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun requestMapping() : String {
        return  "request-mapping"
    }

    //object mapper
    //json -> object
    //object -> json
    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest) : UserRequest {
        //들어올때는 json -> object
        println(userRequest)
        //return시 object-> json
        return userRequest
    }
}