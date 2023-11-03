package org.continuum.codingsb

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import lombok.Data
import lombok.ToString

@Entity
@Data
@ToString(exclude = ["itemList"])
class Product (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val name: String,

    @OneToMany(mappedBy = "product")
    val itemList: List<Item> = ArrayList<Item>()
)