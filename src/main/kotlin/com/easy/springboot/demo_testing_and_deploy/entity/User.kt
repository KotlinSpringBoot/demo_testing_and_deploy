package com.easy.springboot.demo_testing_and_deploy.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.*

/**
 * Created by Kor on 2018-02-08 12:44:04. author: 东海陈光剑
 */
@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var gmtCreate = Date()
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var gmtModify = Date()
    var isDeleted = 0

    @Column(unique = true, length = 100)
    var username = ""
    var password = ""
    @ManyToMany(targetEntity = Role::class, fetch = FetchType.EAGER)
    lateinit var roles: Set<Role>
}
