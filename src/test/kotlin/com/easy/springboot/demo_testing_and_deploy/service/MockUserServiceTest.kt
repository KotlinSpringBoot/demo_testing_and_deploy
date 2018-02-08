package com.easy.springboot.demo_testing_and_deploy.service

import com.easy.springboot.demo_testing_and_deploy.dao.UserDao
import com.easy.springboot.demo_testing_and_deploy.entity.Role
import com.easy.springboot.demo_testing_and_deploy.entity.User
import com.easy.springboot.demo_testing_and_deploy.service.impl.UserServiceImpl
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MockUserServiceTest {
    @Mock
    lateinit var mockUserDao: UserDao // mock 一个DAO层的接口
    @InjectMocks
    lateinit var userService: UserServiceImpl// Mock一个 Service 的实现类，用 @InjectMocks。注意这里是实现类 UserServiceImpl

    @Before
    fun setUp() {
        // initMocks 必须,否则 @Mock 注解无效
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testGetOne() {
        val mockUser = User()
        mockUser.id = 101
        mockUser.username = "mockUser"
        mockUser.password = "123456"

        val roles = mutableSetOf<Role>()
        val r1 = Role()
        r1.role = "ROLE_USER"
        val r2 = Role()
        r1.role = "ROLE_ADMIN"
        roles.add(r1)
        roles.add(r2)
        mockUser.roles = roles
        //模拟 UserDao对象
        `when`(mockUserDao.getOne(1)).thenReturn(mockUser)

        val u = userService.getOne(1)
        println(ObjectMapper().writeValueAsString(u))
        Assert.assertTrue(u?.password == "123456")
    }


}


/**
 *
 * Mockito 主要用于 service 层的 mock 测试。mock 的对象一般是对 DAO 层的依赖； 另外就是别人的Service实现类；
 * 官方文档上是这么描述的：

mock()/@Mock: create mockspy()/@Spy: partial mocking, real methods are invoked but still can be verified and stubbed
optionally specify how it should behave via Answer/ReturnValues/MockSettings

when()/given() to specify how a mock should behave
If the provided answers don’t fit your needs, write one yourself extending the Answerinterface

@InjectMocks: automatically inject mocks/spies fields annotated with @Spy or @Mock -- 这句话理解意思是它会把上下文中你标记为@Spy和@Mock的对象都自动注解进去。是不是就相当于把实现类中的私有成员属性（比如ReportMediaDayMapper的依赖）给偷梁换柱了

verify(): to check methods were called with given arguments
can use flexible argument matching, for example any expression via the any()
or capture what arguments where called using @Captor instead

 * */