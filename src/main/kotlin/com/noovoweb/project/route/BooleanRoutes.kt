package com.noovoweb.project.route

import com.noovoweb.project.request.boolean.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.ktor.receiveAndValidate
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.booleanRoutes() {
    route("/boolean") {
        post("/accepted") {
            val request = call.receiveAndValidate<AcceptedRequest>(AcceptedRequestValidator())
            call.respond(DataResponse(data = request, message = "Accepted validation successful"))
        }
    }
}
