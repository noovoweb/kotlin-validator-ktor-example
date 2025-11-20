package com.noovoweb.project.route

import com.noovoweb.project.request.scenario.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.ktor.receiveAndValidate
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.scenarioRoutes() {
    route("/scenario") {
        post("/register") {
            val request = call.receiveAndValidate<UserRegistrationRequest>(UserRegistrationRequestValidator())
            call.respond(DataResponse(data = request, message = "User registration validation successful"))
        }

        post("/order") {
            val request = call.receiveAndValidate<OrderRequest>(OrderRequestValidator())
            call.respond(DataResponse(data = request, message = "Order validation successful"))
        }
    }
}
