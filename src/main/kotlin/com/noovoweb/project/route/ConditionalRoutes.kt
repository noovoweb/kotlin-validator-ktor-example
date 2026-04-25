package com.noovoweb.project.route

import com.noovoweb.project.request.conditional.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.ktor.receiveAndValidate
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.conditionalRoutes() {
    route("/conditional") {
        post("/same") {
            val request = call.receiveAndValidate<SameRequest>(SameRequestValidator())
            call.respond(DataResponse(data = request, message = "Same validation successful"))
        }

        post("/different") {
            val request = call.receiveAndValidate<DifferentRequest>(DifferentRequestValidator())
            call.respond(DataResponse(data = request, message = "Different validation successful"))
        }

        post("/fail-fast") {
            val request = call.receiveAndValidate<FailFastRequest>(FailFastRequestValidator())
            call.respond(DataResponse(data = request, message = "FailFast validation successful"))
        }

        post("/valid") {
            val request = call.receiveAndValidate<ValidRequest>(ValidRequestValidator())
            call.respond(DataResponse(data = request, message = "Valid (nested) validation successful"))
        }
    }
}
