package com.eduproject.trafficsafetyeducation.core.data.source.local.preference

import android.content.Context

internal class ScoreSharedPreference(context: Context)  {
    companion object {
        private const val PRETEST_PREFS_NAME = "pretest_pref"
        private const val POSTEST_PREFS_NAME = "postest_pref"
        private const val VALUE = "value"
    }

    private val pretest_preferences = context.getSharedPreferences(PRETEST_PREFS_NAME, Context.MODE_PRIVATE)
    private val postest_preferences = context.getSharedPreferences(POSTEST_PREFS_NAME, Context.MODE_PRIVATE)

    fun setPretestScore(token: Int) {
        val editor = pretest_preferences.edit()
        editor.putInt(VALUE, token)
        editor.apply()
    }
    fun setPostestScore(token: Int) {
        val editor = postest_preferences.edit()
        editor.putInt(VALUE, token)
        editor.apply()
    }

    fun getPretest(): Int {
        return pretest_preferences.getInt(VALUE, 0)
    }

    fun getPostest(): Int {
        return postest_preferences.getInt(VALUE, 0)
    }
}