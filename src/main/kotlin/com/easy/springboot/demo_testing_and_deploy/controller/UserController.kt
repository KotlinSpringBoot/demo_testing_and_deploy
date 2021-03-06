
package com.easy.springboot.demo_testing_and_deploy.controller
import com.easy.springboot.demo_testing_and_deploy.dao.UserDao
import com.easy.springboot.demo_testing_and_deploy.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import javax.servlet.http.HttpServletRequest
/**
     * Created by Kor on 2018-02-08 12:44:04. author: 东海陈光剑
     */
@RestController
@RequestMapping("/user")
class UserController {
    @Autowired lateinit var UserDao: UserDao
    @GetMapping(value = ["/"])
    fun user(request: HttpServletRequest): List<User>{
        return UserDao.findAll()
    }
    @GetMapping(value = ["/{id}"])
    fun getOne(@PathVariable("id") id:Long): User {
        return UserDao.getOne(id)
    }
}
