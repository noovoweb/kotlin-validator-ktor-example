package com.noovoweb.project.route

import com.noovoweb.project.request.network.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.ktor.receiveAndValidate
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.networkRoutes() {
    route("/network") {
        post("/ip") {
            val request = call.receiveAndValidate<IpRequest>(IpRequestValidator())
            call.respond(DataResponse(data = request, message = "IP validation successful"))
        }

        post("/ipv4") {
            val request = call.receiveAndValidate<IpV4Request>(IpV4RequestValidator())
            call.respond(DataResponse(data = request, message = "IPv4 validation successful"))
        }

        post("/ipv6") {
            val request = call.receiveAndValidate<IpV6Request>(IpV6RequestValidator())
            call.respond(DataResponse(data = request, message = "IPv6 validation successful"))
        }

        post("/mac-address") {
            val request = call.receiveAndValidate<MacAddressRequest>(MacAddressRequestValidator())
            call.respond(DataResponse(data = request, message = "MAC address validation successful"))
        }

        post("/port") {
            val request = call.receiveAndValidate<PortRequest>(PortRequestValidator())
            call.respond(DataResponse(data = request, message = "Port validation successful"))
        }
    }
}
