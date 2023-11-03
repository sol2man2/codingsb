package org.continuum.codingsb

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository

    fun getCustomerByName(name: String): CustomerDto {
        val customer = customerRepository.findByName(name)
        println("order id: ${customer.ordersList.get(0).id}")
        println("product: ${customer.ordersList.get(0).itemList.get(0).product.name}, " +
                "${customer.ordersList.get(0).itemList.get(1).product.name}")

        return CustomerDto(customer.id, customer.name)
    }
}
