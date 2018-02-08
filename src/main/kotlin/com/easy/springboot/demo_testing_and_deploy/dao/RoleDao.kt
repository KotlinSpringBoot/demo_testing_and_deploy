package com.easy.springboot.demo_testing_and_deploy.dao

import com.easy.springboot.demo_testing_and_deploy.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by Kor on 2018-02-08 12:44:14. author: 东海陈光剑
 */
interface RoleDao : JpaRepository<Role, Long> {
}
