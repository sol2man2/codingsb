package org.continuum.codingsb

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class CustomerControllerTest {

    companion object {
        @Container
        val postgreSQLContainer = PostgreSQLContainer<Nothing>("postgres:15.4")

        @JvmStatic
        @DynamicPropertySource
        fun properties(register: DynamicPropertyRegistry) {
            register.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl)
            register.add("spring.datasource.username", postgreSQLContainer::getUsername)
            register.add("spring.datasource.password", postgreSQLContainer::getPassword)
        }
    }

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun getCustomerFromController() {
        val result =
            mockMvc.perform(get("/api/customer/kacey"))
                .andDo(print())
                .andExpect(status().isOk())
    }
}