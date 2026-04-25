package com.noovoweb.project.request.string

import com.noovoweb.validator.*
import kotlinx.serialization.Serializable

@Validated
@Serializable
data class EmailRequest(
    @Email
    val email: String?
)

@Validated
@Serializable
data class UrlRequest(
    @Url
    val url: String?
)

@Validated
@Serializable
data class UuidRequest(
    @Uuid
    val uuid: String?
)

@Validated
@Serializable
data class RequiredRequest(
    @Required
    val value: String?
)

@Validated
@Serializable
data class LengthRequest(
    @Length(min = 5, max = 10)
    val value: String?
)

@Validated
@Serializable
data class MinLengthRequest(
    @MinLength(5)
    val value: String?
)

@Validated
@Serializable
data class MaxLengthRequest(
    @MaxLength(10)
    val value: String?
)

@Validated
@Serializable
data class PatternRequest(
    @Pattern("^[A-Z]{3}$")
    val code: String?
)

@Validated
@Serializable
data class AlphaRequest(
    @Alpha
    val value: String?
)

@Validated
@Serializable
data class AlphanumericRequest(
    @Alphanumeric
    val value: String?
)

@Validated
@Serializable
data class AsciiRequest(
    @Ascii
    val value: String?
)

@Validated
@Serializable
data class LowercaseRequest(
    @Lowercase
    val value: String?
)

@Validated
@Serializable
data class UppercaseRequest(
    @Uppercase
    val value: String?
)

@Validated
@Serializable
data class StartsWithRequest(
    @StartsWith("PRE")
    val value: String?
)

@Validated
@Serializable
data class EndsWithRequest(
    @EndsWith("END")
    val value: String?
)

@Validated
@Serializable
data class ContainsRequest(
    @Contains("test")
    val value: String?
)

@Validated
@Serializable
data class JsonRequest(
    @Json
    val jsonString: String?
)

@Validated
@Serializable
data class OneOfRequest(
    @OneOf(["RED", "GREEN", "BLUE"])
    val color: String?
)

@Validated
@Serializable
data class NotOneOfRequest(
    @NotOneOf(["BANNED", "FORBIDDEN"])
    val value: String?
)

@Validated
@Serializable
data class LuhnRequest(
    @Luhn
    val cardNumber: String?
)
