package com.arquitecture.poc.hexagonalarch.adapters.api

import com.arquitecture.poc.hexagonalarch.HexagonalArchApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest(
    classes = arrayOf(HexagonalArchApplication::class),
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BaseApiIntegrationTest {

    @Autowired
    lateinit var mvc: MockMvc
}