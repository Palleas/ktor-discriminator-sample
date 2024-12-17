package com.example

import com.example.generated.controllers.SomeController
import com.example.generated.controllers.SomeController.Companion.someRoutes
import com.example.generated.controllers.TypedApplicationCall
import com.example.generated.models.SomeObj
import com.example.generated.models.State
import com.example.generated.models.StateA
import com.example.generated.models.StateB
import com.example.generated.models.StateBMode
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        someRoutes(object: SomeController {
            override suspend fun getSomeObject(call: TypedApplicationCall<SomeObj>) {
                call.respondTyped(SomeObj(state = StateA()))
            }

            override suspend fun sendSomeObject(state: State, call: TypedApplicationCall<SomeObj>) {
                call.respondTyped(SomeObj(state = state))
            }
        })
    }
}
