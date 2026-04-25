package com.noovoweb.project.request.network

import com.noovoweb.validator.*
import kotlinx.serialization.Serializable

@Validated
@Serializable
data class IpRequest(
    @IP
    val ipAddress: String?
)

@Validated
@Serializable
data class IpV4Request(
    @IPv4
    val ipAddress: String?
)

@Validated
@Serializable
data class IpV6Request(
    @IPv6
    val ipAddress: String?
)

@Validated
@Serializable
data class MacAddressRequest(
    @MacAddress
    val macAddress: String?
)

@Validated
@Serializable
data class PortRequest(
    @Port
    val port: Int?
)
