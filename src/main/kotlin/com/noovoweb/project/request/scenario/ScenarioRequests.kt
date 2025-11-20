package com.noovoweb.project.request.scenario

import com.noovoweb.validator.*
import kotlinx.serialization.Serializable

/**
 * User registration scenario demonstrating multiple validators working together
 */
@Validated
@Serializable
data class UserRegistrationRequest(
    @Required
    @Email
    val email: String?,

    @Required
    @MinLength(2)
    @MaxLength(50)
    val firstName: String?,

    @Required
    @MinLength(2)
    @MaxLength(50)
    val lastName: String?,

    @Required
    @Min(18.0)
    @Max(120.0)
    val age: Int?,

    @Valid
    val address: UserAddress?
)

@Validated
@Serializable
data class UserAddress(
    @Required
    @MinLength(5)
    val street: String?,

    @Required
    val city: String?,

    @Required
    @Pattern("^[A-Z]{2}$")
    val state: String?,

    @Required
    @Pattern("^\\d{5}$")
    val zipCode: String?
)

/**
 * E-commerce order scenario
 */
@Validated
@Serializable
data class OrderRequest(
    @Required
    @Uuid
    val orderId: String?,

    @NotEmpty
    @Valid(each = true)
    val items: List<OrderItem>?,

    @Required
    @Min(0.0)
    val totalAmount: Double?,

    @Valid
    val shippingAddress: UserAddress?
)

@Validated
@Serializable
data class OrderItem(
    @Required
    val productName: String?,

    @Required
    @Positive
    val quantity: Int?,

    @Required
    @Positive
    val price: Double?
)
