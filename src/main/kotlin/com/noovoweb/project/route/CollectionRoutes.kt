package com.noovoweb.project.route

import com.noovoweb.project.request.collection.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.ktor.receiveAndValidate
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.collectionRoutes() {
    route("/collection") {
        post("/not-empty") {
            val request = call.receiveAndValidate<NotEmptyRequest>(NotEmptyRequestValidator())
            call.respond(DataResponse(data = request, message = "NotEmpty validation successful"))
        }

        post("/size") {
            val request = call.receiveAndValidate<SizeRequest>(SizeRequestValidator())
            call.respond(DataResponse(data = request, message = "Size validation successful"))
        }

        post("/min-size") {
            val request = call.receiveAndValidate<MinSizeRequest>(MinSizeRequestValidator())
            call.respond(DataResponse(data = request, message = "MinSize validation successful"))
        }

        post("/max-size") {
            val request = call.receiveAndValidate<MaxSizeRequest>(MaxSizeRequestValidator())
            call.respond(DataResponse(data = request, message = "MaxSize validation successful"))
        }

        post("/distinct") {
            val request = call.receiveAndValidate<DistinctRequest>(DistinctRequestValidator())
            call.respond(DataResponse(data = request, message = "Distinct validation successful"))
        }

        post("/contains-value") {
            val request = call.receiveAndValidate<ContainsValueRequest>(ContainsValueRequestValidator())
            call.respond(DataResponse(data = request, message = "ContainsValue validation successful"))
        }
    }
}
