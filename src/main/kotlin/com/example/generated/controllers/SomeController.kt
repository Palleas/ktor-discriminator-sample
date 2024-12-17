package com.example.generated.controllers

import com.example.generated.models.SomeObj
import com.example.generated.models.State
import io.ktor.http.Headers
import io.ktor.http.Parameters
import io.ktor.server.application.call
import io.ktor.server.plugins.BadRequestException
import io.ktor.server.plugins.ParameterConversionException
import io.ktor.server.request.receive
import io.ktor.server.routing.Route
import io.ktor.server.routing.`get`
import io.ktor.server.routing.post
import io.ktor.util.converters.DefaultConversionService
import io.ktor.util.reflect.typeInfo
import kotlin.Any
import kotlin.String

public interface SomeController {
  /**
   * Route is expected to respond with [com.example.generated.models.SomeObj].
   * Use [com.example.generated.controllers.TypedApplicationCall.respondTyped] to send the response.
   *
   * @param state 
   * @param call Decorated ApplicationCall with additional typed respond methods
   */
  public suspend fun sendSomeObject(state: State, call: TypedApplicationCall<SomeObj>)

  /**
   * Route is expected to respond with [com.example.generated.models.SomeObj].
   * Use [com.example.generated.controllers.TypedApplicationCall.respondTyped] to send the response.
   *
   * @param call Decorated ApplicationCall with additional typed respond methods
   */
  public suspend fun getSomeObject(call: TypedApplicationCall<SomeObj>)

  public companion object {
    /**
     * Mounts all routes for the Some resource
     *
     * - POST /some 
     * - GET /some 
     */
    public fun Route.someRoutes(controller: SomeController) {
      post("/some") {
        val state = call.receive<State>()
        controller.sendSomeObject(state, TypedApplicationCall(call))
      }
      `get`("/some") {
        controller.getSomeObject(TypedApplicationCall(call))
      }
    }

    /**
     * Gets parameter value associated with this name or null if the name is not present.
     * Converting to type R using DefaultConversionService.
     *
     * Throws:
     *   ParameterConversionException - when conversion from String to R fails
     */
    private inline fun <reified R : Any> Parameters.getTyped(name: String): R? {
      val values = getAll(name) ?: return null
      val typeInfo = typeInfo<R>()
      return try {
          @Suppress("UNCHECKED_CAST")
          DefaultConversionService.fromValues(values, typeInfo) as R
      } catch (cause: Exception) {
          throw ParameterConversionException(name, typeInfo.type.simpleName ?:
          typeInfo.type.toString(), cause)
      }
    }

    /**
     * Gets first value from the list of values associated with a name.
     *
     * Throws:
     *   BadRequestException - when the name is not present
     */
    private fun Headers.getOrFail(name: String): String = this[name] ?: throw
        BadRequestException("Header " + name + " is required")
  }
}
