package com.example.kotlinboard.controller.delete

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/api")
class DeleteApiController {
    //Delete가 갖을 수 있는 Method 형태
    //1. path variable
    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
            @RequestParam name: String,
            @RequestParam age: Int
    ): String {
        println(name)
        println(age)
        return name+""+age
    }
    //2. request param
    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
            @PathVariable name: String,
            @PathVariable age: Int
    ):String {
        println(name)
        println(age)
        return name+""+age
    }
}