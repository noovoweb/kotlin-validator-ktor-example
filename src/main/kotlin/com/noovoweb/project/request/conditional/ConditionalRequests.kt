package com.noovoweb.project.request.conditional

import com.noovoweb.validator.*
import kotlinx.serialization.Serializable

@Validated
@Serializable
data class NullableRequest(
    @Nullable
    val optionalValue: String?
)

@Validated
@Serializable
data class SameRequest(
    @Same("password")
    val passwordConfirmation: String?,
    val password: String?
)

@Validated
@Serializable
data class DifferentRequest(
    @Different("email")
    val newEmail: String?,
    val email: String?
)

@Validated
@Serializable
data class FailFastRequest(
    @FailFast
    @MinLength(5)
    @MaxLength(10)
    @Pattern("^[A-Z]+$")
    val value: String?
)

@Validated
@Serializable
data class ValidRequest(
    @Valid
    val nested: NestedData?
)

@Validated
@Serializable
data class NestedData(
    @Required
    @Email
    val email: String?
)
