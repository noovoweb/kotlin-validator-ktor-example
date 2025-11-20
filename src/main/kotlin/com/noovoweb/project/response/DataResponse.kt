package com.noovoweb.project.response

import kotlinx.serialization.Serializable

@Serializable
data class DataResponse<T>(
    val data: T,
    val message: String
)
