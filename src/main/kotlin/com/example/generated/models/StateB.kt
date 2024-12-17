package com.example.generated.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("b")
@Serializable
public data class StateB(
  @SerialName("mode")
  public val mode: StateBMode,
  @SerialName("status")
  public val status: Status = Status.B,
) : State
