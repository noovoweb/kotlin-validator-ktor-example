package com.noovoweb.project.route

import com.noovoweb.project.request.string.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.ktor.receiveAndValidate
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.stringRoutes() {
    route("/string") {
        post("/email") {
            val request = call.receiveAndValidate<EmailRequest>(EmailRequestValidator())
            call.respond(DataResponse(data = request, message = "Email validation successful"))
        }

        post("/url") {
            val request = call.receiveAndValidate<UrlRequest>(UrlRequestValidator())
            call.respond(DataResponse(data = request, message = "URL validation successful"))
        }

        post("/uuid") {
            val request = call.receiveAndValidate<UuidRequest>(UuidRequestValidator())
            call.respond(DataResponse(data = request, message = "UUID validation successful"))
        }

        post("/required") {
            val request = call.receiveAndValidate<RequiredRequest>(RequiredRequestValidator())
            call.respond(DataResponse(data = request, message = "Required validation successful"))
        }

        post("/length") {
            val request = call.receiveAndValidate<LengthRequest>(LengthRequestValidator())
            call.respond(DataResponse(data = request, message = "Length validation successful"))
        }

        post("/min-length") {
            val request = call.receiveAndValidate<MinLengthRequest>(MinLengthRequestValidator())
            call.respond(DataResponse(data = request, message = "MinLength validation successful"))
        }

        post("/max-length") {
            val request = call.receiveAndValidate<MaxLengthRequest>(MaxLengthRequestValidator())
            call.respond(DataResponse(data = request, message = "MaxLength validation successful"))
        }

        post("/pattern") {
            val request = call.receiveAndValidate<PatternRequest>(PatternRequestValidator())
            call.respond(DataResponse(data = request, message = "Pattern validation successful"))
        }

        post("/alpha") {
            val request = call.receiveAndValidate<AlphaRequest>(AlphaRequestValidator())
            call.respond(DataResponse(data = request, message = "Alpha validation successful"))
        }

        post("/alphanumeric") {
            val request = call.receiveAndValidate<AlphanumericRequest>(AlphanumericRequestValidator())
            call.respond(DataResponse(data = request, message = "Alphanumeric validation successful"))
        }

        post("/ascii") {
            val request = call.receiveAndValidate<AsciiRequest>(AsciiRequestValidator())
            call.respond(DataResponse(data = request, message = "ASCII validation successful"))
        }

        post("/lowercase") {
            val request = call.receiveAndValidate<LowercaseRequest>(LowercaseRequestValidator())
            call.respond(DataResponse(data = request, message = "Lowercase validation successful"))
        }

        post("/uppercase") {
            val request = call.receiveAndValidate<UppercaseRequest>(UppercaseRequestValidator())
            call.respond(DataResponse(data = request, message = "Uppercase validation successful"))
        }

        post("/starts-with") {
            val request = call.receiveAndValidate<StartsWithRequest>(StartsWithRequestValidator())
            call.respond(DataResponse(data = request, message = "StartsWith validation successful"))
        }

        post("/ends-with") {
            val request = call.receiveAndValidate<EndsWithRequest>(EndsWithRequestValidator())
            call.respond(DataResponse(data = request, message = "EndsWith validation successful"))
        }

        post("/contains") {
            val request = call.receiveAndValidate<ContainsRequest>(ContainsRequestValidator())
            call.respond(DataResponse(data = request, message = "Contains validation successful"))
        }

        post("/json") {
            val request = call.receiveAndValidate<JsonRequest>(JsonRequestValidator())
            call.respond(DataResponse(data = request, message = "JSON validation successful"))
        }

        post("/one-of") {
            val request = call.receiveAndValidate<OneOfRequest>(OneOfRequestValidator())
            call.respond(DataResponse(data = request, message = "OneOf validation successful"))
        }

        post("/not-one-of") {
            val request = call.receiveAndValidate<NotOneOfRequest>(NotOneOfRequestValidator())
            call.respond(DataResponse(data = request, message = "NotOneOf validation successful"))
        }

        post("/luhn") {
            val request = call.receiveAndValidate<LuhnRequest>(LuhnRequestValidator())
            call.respond(DataResponse(data = request, message = "Luhn validation successful"))
        }
    }
}
