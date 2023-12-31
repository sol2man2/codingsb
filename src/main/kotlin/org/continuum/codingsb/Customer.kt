package org.continuum.codingsb

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import lombok.Getter
import lombok.ToString

@Entity
@Getter
@ToString(exclude = ["ordersList"])
class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column
    var name: String,

    @OneToMany(mappedBy = "customer")
    val ordersList: List<Orders> = ArrayList<Orders>()
)
