package com.noovoweb.project.request.datetime

import com.noovoweb.validator.*
import kotlinx.serialization.Serializable

@Validated
@Serializable
data class PastRequest(
    @Past
    val date: String?  // ISO-8601 format
)

@Validated
@Serializable
data class FutureRequest(
    @Future
    val date: String?
)

@Validated
@Serializable
data class TodayRequest(
    @Today
    val date: String?
)

@Validated
@Serializable
data class IsoDateRequest(
    @IsoDate
    val date: String?
)

@Validated
@Serializable
data class IsoDateTimeRequest(
    @IsoDateTime
    val dateTime: String?
)

@Validated
@Serializable
data class DateFormatRequest(
    @DateFormat("yyyy-MM-dd")
    val date: String?
)
