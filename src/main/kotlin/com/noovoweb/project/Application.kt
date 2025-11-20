package com.noovoweb.project

import com.noovoweb.project.route.*
import com.noovoweb.validator.ktor.ValidationPlugin
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import java.util.*

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
