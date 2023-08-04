package com.example.kotlinboard.controller.page

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PageController {
    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }


    //페이지 관련된 @Controller에서 json string을 줘야한다던지 할땐 @ResponseBody를 사용
    @ResponseBody
    @GetMapping("/test")
    fun response(): String {
        return "main.html"
    }
}