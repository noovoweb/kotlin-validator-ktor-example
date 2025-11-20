package com.noovoweb.project.route

import com.noovoweb.project.request.file.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.ktor.receiveAndValidate
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.fileRoutes() {
    route("/file") {
        post("/extension") {
            val request = call.receiveAndValidate<FileExtensionRequest>(FileExtensionRequestValidator())
            call.respond(DataResponse(data = request, message = "FileExtension validation successful"))
        }

        post("/mime-type") {
            val request = call.receiveAndValidate<MimeTypeRequest>(MimeTypeRequestValidator())
            call.respond(DataResponse(data = request, message = "MimeType validation successful"))
        }

        post("/max-size") {
            val request = call.receiveAndValidate<MaxFileSizeRequest>(MaxFileSizeRequestValidator())
            call.respond(DataResponse(data = request, message = "MaxFileSize validation successful"))
        }
    }
}
