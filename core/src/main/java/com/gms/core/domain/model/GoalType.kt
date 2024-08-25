package com.gms.core.domain.model

sealed class GoalType(val value: String) {
    object LoseWeight: GoalType("lose_weight")
    object MaintainWeight: GoalType("maintain_weight")
    object GainWeight: GoalType("gain_weight")

    companion object {
        fun fromString(value: String): GoalType {
            return when(value) {
                "lose_weight" -> LoseWeight
                "maintain_weight" -> MaintainWeight
                "gain_weight" -> GainWeight
                else -> MaintainWeight
            }
        }
    }

}