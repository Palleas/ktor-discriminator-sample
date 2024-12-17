package com.example.generated.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("a")
@Serializable
public data class StateA(
  @SerialName("status")
  public val status: Status = Status.A,
) : State
