package com.easy.springboot.demo_testing_and_deploy.service.impl

import com.easy.springboot.demo_testing_and_deploy.dao.RoleDao
import com.easy.springboot.demo_testing_and_deploy.entity.Role
import com.easy.springboot.demo_testing_and_deploy.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by Kor on 2018-02-08 12:44:14. author: 东海陈光剑
 */
@Service
class RoleServiceImpl : RoleService {
    @Autowired lateinit var roleDao: RoleDao
    override fun findAll(): List<Role> {
        return roleDao.findAll()
    }
}
