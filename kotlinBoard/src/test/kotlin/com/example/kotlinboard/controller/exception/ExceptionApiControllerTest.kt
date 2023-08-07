package com.example.kotlinboard.controller.exception

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.util.LinkedMultiValueMap

@WebMvcTest
@AutoConfigureMockMvc
class ExceptionApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun helloTest() {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/exception/hello")
        ).andExpect (
            MockMvcResultMatchers.status().`is`(200)
        ).andExpect(
                MockMvcResultMatchers.content().string("hello")
        ).andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun getTest() {
        val queryParams = LinkedMultiValueMap<String,String>()
        queryParams.add("name","steve")
        queryParams.add("age","20")

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/exception").queryParams(queryParams)
        ).andExpect(
                MockMvcResultMatchers.status().isOk
        ).andExpect(
                MockMvcResultMatchers.content().string("steve20")
        ).andDo(MockMvcResultHandlers.print())
    }
    @Test
    fun getFailTest() {
        val queryParams = LinkedMultiValueMap<String,String>()
        queryParams.add("name","steve")
        queryParams.add("age","9")

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/exception").queryParams(queryParams)
        ).andExpect(
                MockMvcResultMatchers.status().isBadRequest
        ).andExpect(
                MockMvcResultMatchers.content().contentType("application/json")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("\$.result_code").value("FAIL")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("\$.errors[0].field").value("age")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("\$.errors[0].value").value("9")
        )
                .andDo(MockMvcResultHandlers.print())
    }
}