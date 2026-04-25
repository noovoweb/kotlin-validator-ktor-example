package com.noovoweb.project.request.boolean

import com.noovoweb.validator.*
import kotlinx.serialization.Serializable

@Validated
@Serializable
data class AcceptedRequest(
    @Accepted
    val termsAccepted: Boolean?
)
