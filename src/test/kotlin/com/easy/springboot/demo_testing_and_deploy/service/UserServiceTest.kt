package com.easy.springboot.demo_testing_and_deploy.service

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class UserServiceTest {

    @Autowired lateinit var userService: UserService

    @Test
    fun testFindAll() {
        Assert.assertTrue(userService.findAll().size == 2)
    }

}