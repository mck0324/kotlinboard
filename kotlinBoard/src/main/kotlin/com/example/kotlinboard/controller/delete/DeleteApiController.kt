package com.example.kotlinboard.controller.delete

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import kotlin.math.min

@RestController()
@RequestMapping("/api")
@Validated
class DeleteApiController {
    //Delete가 갖을 수 있는 Method 형태
    //1. path variable
    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
            @RequestParam name: String,
            @NotNull(message = "age 값이 누락되었습니다.")
            @Min(value = 20, message = "age는 20보다 커야 합니다.")
            @RequestParam age: Int
    ): String {
        println(name)
        println(age)
        return name+""+age
    }
    //2. request param
    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
            @PathVariable @Size(min = 2, max = 5, message = "name의 길이는 2~5") @NotNull
            name: String,
            @NotNull(message = "age 값이 누락되었습니다.")
            @Min(value = 20, message = "age는 20보다 커야 합니다.")
            @PathVariable age: Int
    ):String {
        println(name)
        println(age)
        return name+""+age
    }
}