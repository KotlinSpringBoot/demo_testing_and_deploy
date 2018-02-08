package com.easy.springboot.demo_testing_and_deploy.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ClassUtilController {

    @GetMapping("/classinfo")
    fun classinfo(@RequestParam("classname") classname: String): List<MethodInfo> {
        val result = mutableListOf<MethodInfo>()

        Class.forName(classname).declaredMethods.forEach {

            val paramsList = mutableListOf<MethodParam>()
            it.parameters.forEach {
                paramsList.add(MethodParam(it.name, it.type.canonicalName))
            }

            result.add(
                    MethodInfo(
                            methodName = it.name,
                            params = paramsList,
                            returnType = it.returnType.canonicalName
                    )
            )
        }
        return result
    }
}

data class MethodInfo(var methodName: String, var params: List<MethodParam>, var returnType: String)
data class MethodParam(var name: String, var type: String)