package org.continuum.codingsb

import lombok.Getter

@Getter
data class CustomerDto (
    val id: Long,
    val name: String
)
