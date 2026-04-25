package com.noovoweb.project.request.numeric

import com.noovoweb.validator.*
import kotlinx.serialization.Serializable

@Validated
@Serializable
data class MinRequest(
    @Min(18.0)
    val age: Double?
)

@Validated
@Serializable
data class MaxRequest(
    @Max(100.0)
    val value: Double?
)

@Validated
@Serializable
data class BetweenRequest(
    @Between(min = 1.0, max = 100.0)
    val score: Double?
)

@Validated
@Serializable
data class PositiveRequest(
    @Positive
    val amount: Double?
)

@Validated
@Serializable
data class NegativeRequest(
    @Negative
    val debt: Double?
)

@Validated
@Serializable
data class ZeroRequest(
    @Zero
    val value: Double?
)

@Validated
@Serializable
data class DivisibleByRequest(
    @DivisibleBy(5)
    val value: Int?
)

@Validated
@Serializable
data class EvenRequest(
    @Even
    val number: Int?
)

@Validated
@Serializable
data class OddRequest(
    @Odd
    val number: Int?
)

@Validated
@Serializable
data class DecimalRequest(
    @Decimal
    val price: Double?
)

@Validated
@Serializable
data class DecimalPlacesRequest(
    @DecimalPlaces(2)
    val price: Double?
)

@Validated
@Serializable
data class IntegerRequest(
    @Integer
    val count: Int?
)
