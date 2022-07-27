package com.example.plugins

import com.example.routes.userRoutes
import io.ktor.application.*
import io.ktor.routing.*

fun Application.configureRouting() {

    install(Routing){
        userRoutes()
    }

}
