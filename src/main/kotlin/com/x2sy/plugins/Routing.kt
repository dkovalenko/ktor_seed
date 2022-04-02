package com.x2sy.plugins

import com.x2sy.domain.response.model.ApiResultError
import io.ktor.server.routing.*
import io.ktor.server.locations.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import com.x2sy.domain.video.registerVideoRoutes
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.*

fun Application.configureRouting() {
    install(Locations)

    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respond(ApiResultError(500, cause.toString()))
        }
    }

    install(ContentNegotiation) {
        json()
    }

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }

    registerVideoRoutes()
}


