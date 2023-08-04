package com.example.kotlinboard.controller.response

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/api/response")
class ResponseApiController {
    //1.get
    //클라이언트 잘못요청 4xx
    @GetMapping("")
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {
        //코틀린스럽게
        return age?.let {
            //age not null
            if (it < 20) {
                return ResponseEntity.status(400).body("age 값이 20보다 커야 합니다.")
            }
            ResponseEntity.ok("OK")
        }?: kotlin.run {
            //age null
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

        //일반적
        /*
        //0.age == null -> 400 error
        if (age == null) {
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

        //1.age > 20 -> 400 error
        if (age < 20) {
            return ResponseEntity.status(400).body("age 값이 20보다 커야 합니다.")
        }

        println(age)
        return ResponseEntity.ok("OK ")
        */

    }
    //2.post 200

    //3.put 201

    //4.delete 500
}