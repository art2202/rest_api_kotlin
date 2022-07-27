package com.example.routes

import com.example.model.User
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.userRoutes(){
    route("/user"){
        get("{id}") {
            val id = call.parameters["id"]?.toIntOrNull() ?:
            return@get call.respondText(HttpStatusCode.NotAcceptable.description, status = HttpStatusCode.NotAcceptable)
            val user = getUser(id)
                ?: return@get call.respondText(HttpStatusCode.NotFound.description, status = HttpStatusCode.NotFound)

            call.respond(user)
        }
        get("/"){
            call.respond(getUsers())
        }
    }
}

fun getUser(id: Int): User? {
    val listUser = arrayListOf(
        User(1, "a"),
        User(2, "ab"),
        User(3, "abc"),
        User(4, "abcd"),
        User(5, "abcde"),
        User(6, "abcdef")
    )

    return listUser.find { id == it.id }
}

fun getUsers(): ArrayList<User> {
    return arrayListOf(
        User(1, "a"),
        User(2, "ab"),
        User(3, "abc"),
        User(4, "abcd"),
        User(5, "abcde"),
        User(6, "abcdef")
    )
}



