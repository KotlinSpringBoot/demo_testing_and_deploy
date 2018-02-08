package com.easy.springboot.demo_testing_and_deploy.controller

import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest
class UserControllerTest {

    @Autowired
    lateinit var context: WebApplicationContext
    lateinit var mvc: MockMvc
    @Before
    fun setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build()
    }

    @Test
    fun testFetchUser1() {
        val output = """
// 20180208214800
// http://127.0.0.1:8012/user/1

{
  "id": 1,
  "gmtCreate": "2018-02-08 12:58:14",
  "gmtModify": "2018-02-08 12:58:14",
  "username": "user",
  "password": "user",
  "roles": [
    {
      "id": 1,
      "gmtCreate": "2018-02-08 12:58:14",
      "gmtModify": "2018-02-08 12:58:14",
      "role": "ROLE_USER"
    }
  ]
}
"""

        mvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("""
                    "username":"user"
                """.trimIndent())))
                .andDo {
                    println("it.request.method=${it.request.method}")
                    println("it.response.contentAsString=${it.response.contentAsString}")
                }
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.roles[0].role", Matchers.equalTo("ROLE_USER")))

    }
}