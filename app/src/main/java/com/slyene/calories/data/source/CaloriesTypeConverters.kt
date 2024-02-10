package com.slyene.calories.data.source

import android.net.Uri
import androidx.room.TypeConverter

class CaloriesTypeConverters {
    @TypeConverter
    fun fromUriToString(uri: Uri?): String {
        return uri?.toString() ?: ""
    }

    @TypeConverter
    fun fromStringToUri(string: String): Uri? {
        return if (string.isEmpty()) { null }
        else { Uri.parse(string) }
    }
}