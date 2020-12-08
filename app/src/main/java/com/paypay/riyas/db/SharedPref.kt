package com.paypay.riyas.db

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class SharedPref(context: Context) {
    private val applicationContext = context.applicationContext
    private val editor: SharedPreferences.Editor
    private val sharedPreferences: SharedPreferences
    init {

         sharedPreferences = applicationContext.getSharedPreferences(
            "MySharedPref",
            MODE_PRIVATE
        )
        editor = sharedPreferences.edit()

    }



     fun saveLastSyncedTime(lastSyncedTimeStamp: Long) {
      /*  dataStore.edit { preferences ->
            preferences[LAST_SYNCED] = lastSyncedTimeStamp
        }*/
        editor.putLong(LAST_SYNCED_TIME,lastSyncedTimeStamp)
         editor.commit()
    }

    fun getLastSyncedTime() :Long{

       return sharedPreferences.getLong(LAST_SYNCED_TIME,-1)
    }


    companion object {
        val LAST_SYNCED = preferencesKey<Long>(name = "last_synced")
        val LAST_SYNCED_TIME =  "last_synced"
    }
}