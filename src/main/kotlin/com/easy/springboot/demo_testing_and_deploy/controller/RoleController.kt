
package com.easy.springboot.demo_testing_and_deploy.controller
import com.easy.springboot.demo_testing_and_deploy.dao.RoleDao
import com.easy.springboot.demo_testing_and_deploy.entity.Role
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import javax.servlet.http.HttpServletRequest
/**
     * Created by Kor on 2018-02-08 12:44:14. author: 东海陈光剑
     */
@RestController
@RequestMapping("/role")
class RoleController {
    @Autowired lateinit var RoleDao: RoleDao
    @GetMapping(value = ["/"])
    fun role(request: HttpServletRequest): List<Role>{
        return RoleDao.findAll()
    }
    @GetMapping(value = ["/{id}"])
    fun getOne(@PathVariable("id") id:Long): Role {
        return RoleDao.getOne(id)
    }
}
