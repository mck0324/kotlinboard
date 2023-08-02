package com.example.kotlinboard.controller.get

import com.example.kotlinboard.model.http.UserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
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

    @GetMapping("/get-mapping/path-variable/{name}/{age}") //localhost/api/get-mapping/path-variable/{name}
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String {
        println("${name}, ${age}")
        return  name+""+age
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(@PathVariable(value = "name") username : String, @PathVariable(value = "age") age : Int): String {
        val name = "kotlin"
        println("${username},${age}")
        return  username+""+age
    }
    //Query parameter 특징
    //필터링 or 페이지네이션
    //?뒤로 계속해서 붙을 수 있음
    @GetMapping("/get-mapping/query-param") //?name=steve&age=20
    fun queryParam(
            @RequestParam name : String,
            @RequestParam age : Int
    ): String {
        println("${name}, ${age}")
        return name+""+age
    }
    //Query parameter객체
    //?뒤에가 원래는 길어지진 않지만 예외를 위해서 많아질경우 객체를 생성할때도 있음
    //Object로 할시 phone-number 처럼 -가 들어가면 안됨 사용하기 위해선 Map<> or QueryParam(value = )등으로 해줘야함
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam  map: Map<String, Any>): Map<String, Any> {
        println(map)
        //map에서 특정값 가져오기
        val username = map.get("name")
        println(username)
        return map
    }
}