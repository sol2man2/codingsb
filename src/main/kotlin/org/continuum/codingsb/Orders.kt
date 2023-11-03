package org.continuum.codingsb

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import lombok.Data
import lombok.ToString

@Entity
@Data
@ToString(exclude = ["itemList"])
class Orders (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    val customer: Customer,

    @OneToMany(mappedBy = "orders")
    val itemList: List<Item> = ArrayList<Item>()
)