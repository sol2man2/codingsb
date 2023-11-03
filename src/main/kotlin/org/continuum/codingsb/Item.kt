package org.continuum.codingsb

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.criteria.Order
import lombok.Data

@Entity
@Data
class Item (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "orders_id")
    val orders: Orders,

    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: Product
)