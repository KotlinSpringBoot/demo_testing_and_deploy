package com.easy.springboot.demo_testing_and_deploy.dao

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class UserDaoTest {
    @Autowired lateinit var userDao: UserDao

    @Test
    fun testFindAll() {
        Assert.assertTrue(userDao.findAll().size == 2)
    }
}