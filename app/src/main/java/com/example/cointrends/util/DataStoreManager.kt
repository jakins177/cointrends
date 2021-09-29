package com.example.cointrends.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class DataStoreManager(val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "trend_data")

    companion object {

        val ID = stringPreferencesKey("ID")
        val PHONE_NUMBER = stringPreferencesKey("PHONE_NUMBER")
        val ADDRESS = stringPreferencesKey("ADDRESS")

    }

    suspend fun savetoDataStore(trendsID : String) {
        context.dataStore.edit {

            it[ID]  = trendsID;
//            it[PHONE_NUMBER]
//            it[ADDRESS]

        }
    }

    suspend fun getFromDataStore() = context.dataStore.data.map {

                it[ID]?:""

    }




}




