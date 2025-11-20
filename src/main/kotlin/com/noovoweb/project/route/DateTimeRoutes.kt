package com.noovoweb.project.route

import com.noovoweb.project.request.datetime.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.ktor.receiveAndValidate
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.dateTimeRoutes() {
    route("/datetime") {
        post("/past") {
            val request = call.receiveAndValidate<PastRequest>(PastRequestValidator())
            call.respond(DataResponse(data = request, message = "Past validation successful"))
        }

        post("/future") {
            val request = call.receiveAndValidate<FutureRequest>(FutureRequestValidator())
            call.respond(DataResponse(data = request, message = "Future validation successful"))
        }

        post("/today") {
            val request = call.receiveAndValidate<TodayRequest>(TodayRequestValidator())
            call.respond(DataResponse(data = request, message = "Today validation successful"))
        }

        post("/iso-date") {
            val request = call.receiveAndValidate<IsoDateRequest>(IsoDateRequestValidator())
            call.respond(DataResponse(data = request, message = "IsoDate validation successful"))
        }

        post("/iso-datetime") {
            val request = call.receiveAndValidate<IsoDateTimeRequest>(IsoDateTimeRequestValidator())
            call.respond(DataResponse(data = request, message = "IsoDateTime validation successful"))
        }

        post("/date-format") {
            val request = call.receiveAndValidate<DateFormatRequest>(DateFormatRequestValidator())
            call.respond(DataResponse(data = request, message = "DateFormat validation successful"))
        }
    }
}
