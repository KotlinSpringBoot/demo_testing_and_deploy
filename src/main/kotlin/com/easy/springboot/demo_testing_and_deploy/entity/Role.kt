package com.easy.springboot.demo_testing_and_deploy.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by Kor on 2018-02-08 12:44:14. author: 东海陈光剑
 */
@Entity
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var gmtCreate = Date()
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var gmtModify = Date()
    var isDeleted = 0

    var role = "ROLE_USER"
}
