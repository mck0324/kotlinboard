package com.example.kotlinboard.controller.get

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api") //localhost/api
class GetApiController {
//    localhost/api/hello or localhost/api/abc
//    path = []에 넣을시 배열로 들어가기에 여러가지 url로 사용가능
    @GetMapping(path = ["/hello","/abc"])
    fun hello(): String {
        return "hello kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    
}