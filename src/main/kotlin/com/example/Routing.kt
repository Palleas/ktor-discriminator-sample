package com.example

import com.example.generated.controllers.SomeController
import com.example.generated.controllers.SomeController.Companion.someRoutes
import com.example.generated.controllers.TypedApplicationCall
import com.example.generated.models.SomeObj
import com.example.generated.models.State
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        someRoutes(object: SomeController {
            override suspend fun getSomeObject(call: TypedApplicationCall<SomeObj>) {
                TODO("Not yet implemented")
            }

            override suspend fun sendSomeObject(state: State, call: TypedApplicationCall<SomeObj>) {
                TODO("Not yet implemented")
            }
        })
    }
}
