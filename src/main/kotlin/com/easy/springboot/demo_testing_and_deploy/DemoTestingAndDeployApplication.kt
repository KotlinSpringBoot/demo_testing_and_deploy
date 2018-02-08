package com.easy.springboot.demo_testing_and_deploy

import com.easy.springboot.demo_testing_and_deploy.dao.RoleDao
import com.easy.springboot.demo_testing_and_deploy.dao.UserDao
import com.easy.springboot.demo_testing_and_deploy.entity.Role
import com.easy.springboot.demo_testing_and_deploy.entity.User
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans

@SpringBootApplication
open class DemoTestingAndDeployApplication

fun main(args: Array<String>) {

    SpringApplicationBuilder().initializers(
            beans {
                bean {
                    ApplicationRunner {
                        try {
                            val roleDao = ref<RoleDao>()
                            // 普通用户角色
                            val roleUser = Role()
                            roleUser.role = "ROLE_USER"
                            val r1 = roleDao.save(roleUser)

                            // 超级管理员角色
                            val roleAdmin = Role()
                            roleAdmin.role = "ROLE_ADMIN"
                            val r2 = roleDao.save(roleAdmin)

                            val userDao = ref<UserDao>()
                            // 普通用户
                            val user = User()
                            user.username = "user"
                            user.password = "user"
                            val userRoles = setOf(r1)
                            user.roles = userRoles
                            userDao.save(user)

                            // 超级管理员用户
                            val admin = User()
                            admin.username = "admin"
                            admin.password = "admin"
                            val adminRoles = setOf(r1, r2)
                            admin.roles = adminRoles
                            userDao.save(admin)

                        } catch (e: Exception) {
                        }
                    }
                }
            }
    ).sources(DemoTestingAndDeployApplication::class.java).run(*args)
}
