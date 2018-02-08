package com.easy.springboot.demo_testing_and_deploy.service

import com.easy.springboot.demo_testing_and_deploy.entity.User

/**
 * Created by Kor on 2018-02-08 12:44:04. author: 东海陈光剑
 */
interface UserService {
    fun findAll(): List<User>
    fun getOne(id:Long):User?
}
