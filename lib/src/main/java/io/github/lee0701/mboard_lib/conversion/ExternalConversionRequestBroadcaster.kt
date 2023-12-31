package io.github.lee0701.mboard_lib.conversion

import android.content.Context
import android.content.Intent
import io.github.lee0701.mboard_lib.conversion.Constants.ACTION_CONVERT_TEXT
import io.github.lee0701.mboard_lib.conversion.Constants.EXTRA_TEXT
import io.github.lee0701.mboard_lib.conversion.Constants.PERMISSION_CONVERT_TEXT

/**
 * mBoard side, requests conversion of a text
 * to Converter
 */
object ExternalConversionRequestBroadcaster {
    fun broadcast(context: Context, text: String) {
        val intent = Intent().apply {
            action = ACTION_CONVERT_TEXT
            putExtra(EXTRA_TEXT, text)
        }
        context.sendBroadcast(intent, PERMISSION_CONVERT_TEXT)
    }
}