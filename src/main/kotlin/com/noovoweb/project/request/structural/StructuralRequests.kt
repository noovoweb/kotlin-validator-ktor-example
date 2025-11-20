package com.noovoweb.project.request.structural

import com.noovoweb.validator.*
import kotlinx.serialization.Serializable

@Validated
@Serializable
data class NestedValidationRequest(
    @Valid
    val address: Address?
)

@Validated
@Serializable
data class Address(
    @Required
    @MinLength(5)
    val street: String?,

    @Required
    @MinLength(2)
    val city: String?,

    @Required
    @Pattern("^[A-Z]{2}$")
    val state: String?,

    @Required
    @Pattern("^\\d{5}$")
    val zipCode: String?
)

@Validated
@Serializable
data class CollectionValidationRequest(
    @Valid(each = true)
    val items: List<Item>?
)

@Validated
@Serializable
data class Item(
    @Required
    val name: String?,

    @Min(0.0)
    val price: Double?
)
