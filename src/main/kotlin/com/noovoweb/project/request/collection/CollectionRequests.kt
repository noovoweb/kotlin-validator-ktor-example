package com.noovoweb.project.request.collection

import com.noovoweb.validator.*
import kotlinx.serialization.Serializable

@Validated
@Serializable
data class NotEmptyRequest(
    @NotEmpty
    val items: List<String>?
)

@Validated
@Serializable
data class SizeRequest(
    @Size(min = 2, max = 5)
    val tags: List<String>?
)

@Validated
@Serializable
data class MinSizeRequest(
    @MinSize(3)
    val items: List<String>?
)

@Validated
@Serializable
data class MaxSizeRequest(
    @MaxSize(10)
    val items: List<String>?
)

@Validated
@Serializable
data class DistinctRequest(
    @Distinct
    val items: List<String>?
)

@Validated
@Serializable
data class ContainsValueRequest(
    @ContainsValue("required")
    val items: List<String>?
)
