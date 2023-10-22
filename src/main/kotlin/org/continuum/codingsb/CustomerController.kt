package org.continuum.codingsb

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {

    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping("/api/customer/{name}")
    fun getCustomer(@PathVariable("name") name: String): ResponseEntity<String> {

        val customerDto = customerService.getCustomerByName(name)
        return ResponseEntity.ok("success id(${customerDto.id}), name(${customerDto.name})")
    }
}