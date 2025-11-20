package com.noovoweb.project.route

import com.noovoweb.project.request.structural.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.ktor.receiveAndValidate
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.structuralRoutes() {
    route("/structural") {
        post("/nested") {
            val request = call.receiveAndValidate<NestedValidationRequest>(NestedValidationRequestValidator())
            call.respond(DataResponse(data = request, message = "Nested validation successful"))
        }

        post("/collection") {
            val request = call.receiveAndValidate<CollectionValidationRequest>(CollectionValidationRequestValidator())
            call.respond(DataResponse(data = request, message = "Collection validation successful"))
        }
    }
}
