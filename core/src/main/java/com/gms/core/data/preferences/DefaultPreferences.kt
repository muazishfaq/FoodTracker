package com.gms.core.data.preferences

import android.content.SharedPreferences
import com.gms.core.domain.model.ActivityLevel
import com.gms.core.domain.model.Gender
import com.gms.core.domain.model.GoalType
import com.gms.core.domain.model.UserInfo
import com.gms.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPref: SharedPreferences
) : Preferences {

    override fun saveAge(age: Int) {
        sharedPref.edit().putInt(Preferences.KEY_AGE, age).apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPref.edit().putFloat(Preferences.KEY_WEIGHT, weight).apply()
    }

    override fun saveHeight(height: Int) {
        sharedPref.edit().putInt(Preferences.KEY_HEIGHT, height).apply()
    }

    override fun saveGender(gender: Gender) {
        sharedPref.edit().putString(Preferences.KEY_GENDER, gender.value).apply()
    }

    override fun saveActivityLevel(activityLevel: ActivityLevel) {
        sharedPref.edit().putString(Preferences.KEY_ACTIVITY_LEVEL, activityLevel.value).apply()
    }

    override fun saveGoalType(goalType: GoalType) {
        sharedPref.edit().putString(Preferences.KEY_GOAL_TYPE, goalType.value).apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPref.edit().putFloat(Preferences.KEY_CARB_RATIO, ratio).apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPref.edit().putFloat(Preferences.KEY_PROTEIN_RATIO, ratio).apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPref.edit().putFloat(Preferences.KEY_FAT_RATIO, ratio).apply()
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharedPref.getInt(Preferences.KEY_AGE, -1)
        val weight = sharedPref.getFloat(Preferences.KEY_WEIGHT, -1f)
        val height = sharedPref.getInt(Preferences.KEY_HEIGHT, -1)
        val gender = sharedPref.getString(Preferences.KEY_GENDER, null)
        val activityLevel = sharedPref.getString(Preferences.KEY_ACTIVITY_LEVEL, null)
        val goalType = sharedPref.getString(Preferences.KEY_GOAL_TYPE, null)
        val carbRatio = sharedPref.getFloat(Preferences.KEY_CARB_RATIO, -1f)
        val proteinRatio = sharedPref.getFloat(Preferences.KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharedPref.getFloat(Preferences.KEY_FAT_RATIO, -1f)
        return UserInfo(
            gender = Gender.fromString(gender ?: "male"),
            age = age,
            weight = weight,
            height = height,
            activityLevel = ActivityLevel.fromString(activityLevel ?: "medium"),
            goalType = GoalType.fromString(goalType ?: "maintain_weight"),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )
    }
}