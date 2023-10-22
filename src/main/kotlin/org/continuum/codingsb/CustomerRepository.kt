package org.continuum.codingsb

import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long> {

    fun findByName(name: String): Customer
}
