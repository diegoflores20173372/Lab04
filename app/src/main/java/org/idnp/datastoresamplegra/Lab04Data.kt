package org.idnp.datastoresamplegra

import android.graphics.Color
import android.graphics.Typeface
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*

class Lab04Data(private val dataStore: DataStore<Preferences>) {

    suspend fun saveDataCourse(
        pa: String,
        ep: String,
        ca: String,
        na: String,
        s: String,
        d: String
    ) {
        dataStore.edit { preferences ->
            preferences[ACADEMIC_PERIOD] = pa
            preferences[PROFESSIONAL_SCHOOL] = ep
            preferences[COURSE_CODE] = ca
            preferences[COURSE_NAME] = na
            preferences[SEMESTER] = s
            preferences[DURATION] = d
        }
    }

    suspend fun saveNoteBackgroundColor(noteBackgroundColor: String) {
        dataStore.edit { preferences ->
            preferences[BACKGROUND_COLOR] = noteBackgroundColor
        }
    }

    suspend fun saveFontText(fontText: String) {
        dataStore.edit { preferences ->
            preferences[FONT_TEXT] = fontText
        }
    }

    suspend fun saveSizeText(sizeText: Float) {
        dataStore.edit { preferences ->
            preferences[SIZE_TEXT] = sizeText
        }
    }

    val academicPeriod: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[ACADEMIC_PERIOD] ?: ""
        }
    val professionalSchool: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[PROFESSIONAL_SCHOOL] ?: ""
        }
    val courseCode: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[COURSE_CODE] ?: ""
        }
    val courseName: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[COURSE_NAME] ?: ""
        }
    val semester: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[SEMESTER] ?: ""
        }
    val duration: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[DURATION] ?: ""
        }
    val backgroundColor: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[BACKGROUND_COLOR] ?: Color.CYAN.toString()
        }
    val fontText: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[FONT_TEXT] ?: Typeface.NORMAL.toString()
        }
    val sizeText: Flow<Float>
        get() = dataStore.data.map { preferences ->
            preferences[SIZE_TEXT] ?: 14.0f
        }

    companion object {
        const val DATA_NAME = "DATA_NAME"

        //Variable to Data Info
        private val ACADEMIC_PERIOD = stringPreferencesKey("academic_period")
        private val PROFESSIONAL_SCHOOL = stringPreferencesKey("professional_school")
        private val COURSE_CODE = stringPreferencesKey("course_code")
        private val COURSE_NAME = stringPreferencesKey("course_name")
        private val SEMESTER = stringPreferencesKey("semester")
        private val DURATION = stringPreferencesKey("duration")

        //Variable to edit style
        private val BACKGROUND_COLOR = stringPreferencesKey("key_app_background_color")
        private val FONT_TEXT = stringPreferencesKey("key_app_font_text")
        private val SIZE_TEXT = floatPreferencesKey("key_app_size_text")
    }
}