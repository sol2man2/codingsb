package org.continuum.codingsb

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository

    fun getCustomerByName(name: String): CustomerDto {

        val customer = customerRepository.findByName(name)
        return CustomerDto(customer.id, customer.name)
    }
}
