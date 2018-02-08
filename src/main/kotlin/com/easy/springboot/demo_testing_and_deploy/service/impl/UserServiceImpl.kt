package com.easy.springboot.demo_testing_and_deploy.service.impl

import com.easy.springboot.demo_testing_and_deploy.dao.UserDao
import com.easy.springboot.demo_testing_and_deploy.entity.User
import com.easy.springboot.demo_testing_and_deploy.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by Kor on 2018-02-08 12:44:04. author: 东海陈光剑
 */
@Service
class UserServiceImpl : UserService {
    @Autowired lateinit var userDao: UserDao
    override fun findAll(): List<User> {
        return userDao.findAll()
    }

    override fun getOne(id: Long): User? {
        return userDao.getOne(id)
    }
}
