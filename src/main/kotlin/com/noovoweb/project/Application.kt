package com.noovoweb.project

import com.noovoweb.project.route.*
import com.noovoweb.validator.ValidationException
import com.noovoweb.validator.ktor.ValidationPlugin
import io.github.oshai.kotlinlogging.KotlinLogging
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.util.*

private val logger = KotlinLogging.logger {}

@Serializable
data class ValidationErrorResponse(
    val status: Int,
    val message: String,
    val errors: Map<String, List<String>>
)

fun main() {
    embeddedServer(Netty, port = 8082, module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    // Install Content Negotiation with JSON
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }

    // Install StatusPages for exception handling
    install(StatusPages) {
        exception<ValidationException> { call, cause ->
            logger.warn { "Validation failed: ${cause.errors}" }
            call.respond(
                HttpStatusCode.UnprocessableEntity,
                ValidationErrorResponse(
                    status = HttpStatusCode.UnprocessableEntity.value,
                    message = "Validation Failed",
                    errors = cause.errors
                )
            )
        }
    }

    // Install Validation Plugin
    install(ValidationPlugin) {
        defaultLocale = Locale.ENGLISH
    }

    // Configure routing
    routing {
        route("/ktor/api") {
            stringRoutes()
            numericRoutes()
            collectionRoutes()
            dateTimeRoutes()
            networkRoutes()
            fileRoutes()
            conditionalRoutes()
            booleanRoutes()
            structuralRoutes()
            scenarioRoutes()
        }
    }
}
