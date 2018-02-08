
package com.easy.springboot.demo_testing_and_deploy.service

import com.easy.springboot.demo_testing_and_deploy.entity.Role

/**
     * Created by Kor on 2018-02-08 12:44:14. author: 东海陈光剑
     */
interface RoleService {
    fun findAll():List<Role>
}
