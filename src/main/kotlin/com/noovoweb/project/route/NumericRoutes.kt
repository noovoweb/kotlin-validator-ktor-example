package com.noovoweb.project.route

import com.noovoweb.project.request.numeric.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.ktor.receiveAndValidate
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.numericRoutes() {
    route("/numeric") {
        post("/min") {
            val request = call.receiveAndValidate<MinRequest>(MinRequestValidator())
            call.respond(DataResponse(data = request, message = "Min validation successful"))
        }

        post("/max") {
            val request = call.receiveAndValidate<MaxRequest>(MaxRequestValidator())
            call.respond(DataResponse(data = request, message = "Max validation successful"))
        }

        post("/between") {
            val request = call.receiveAndValidate<BetweenRequest>(BetweenRequestValidator())
            call.respond(DataResponse(data = request, message = "Between validation successful"))
        }

        post("/positive") {
            val request = call.receiveAndValidate<PositiveRequest>(PositiveRequestValidator())
            call.respond(DataResponse(data = request, message = "Positive validation successful"))
        }

        post("/negative") {
            val request = call.receiveAndValidate<NegativeRequest>(NegativeRequestValidator())
            call.respond(DataResponse(data = request, message = "Negative validation successful"))
        }

        post("/zero") {
            val request = call.receiveAndValidate<ZeroRequest>(ZeroRequestValidator())
            call.respond(DataResponse(data = request, message = "Zero validation successful"))
        }

        post("/divisible-by") {
            val request = call.receiveAndValidate<DivisibleByRequest>(DivisibleByRequestValidator())
            call.respond(DataResponse(data = request, message = "DivisibleBy validation successful"))
        }

        post("/even") {
            val request = call.receiveAndValidate<EvenRequest>(EvenRequestValidator())
            call.respond(DataResponse(data = request, message = "Even validation successful"))
        }

        post("/odd") {
            val request = call.receiveAndValidate<OddRequest>(OddRequestValidator())
            call.respond(DataResponse(data = request, message = "Odd validation successful"))
        }

        post("/decimal") {
            val request = call.receiveAndValidate<DecimalRequest>(DecimalRequestValidator())
            call.respond(DataResponse(data = request, message = "Decimal validation successful"))
        }

        post("/decimal-places") {
            val request = call.receiveAndValidate<DecimalPlacesRequest>(DecimalPlacesRequestValidator())
            call.respond(DataResponse(data = request, message = "DecimalPlaces validation successful"))
        }

        post("/integer") {
            val request = call.receiveAndValidate<IntegerRequest>(IntegerRequestValidator())
            call.respond(DataResponse(data = request, message = "Integer validation successful"))
        }
    }
}
