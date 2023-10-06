package io.github.lee0701.converter

import android.content.Context
import android.content.Intent
import io.github.lee0701.mboard_lib.conversion.Constants.ACTION_CONVERT_TEXT_RESULT
import io.github.lee0701.mboard_lib.conversion.Constants.EXTRA_CANDIDATES
import io.github.lee0701.mboard_lib.conversion.Constants.PERMISSION_RECEIVE_CONVERTED_TEXT

/**
 * Converter side, broadcasts converted
 * result candidates to mBoard side
 */
object ConversionResultBroadcaster {
    fun broadcast(context: Context, candidates: List<List<String>>) {
        val intent = Intent().apply {
            action = ACTION_CONVERT_TEXT_RESULT
            val result = candidates.map { item -> item.joinToString("\t") }.toTypedArray()
            putExtra(EXTRA_CANDIDATES, result)
        }
        context.sendBroadcast(intent, PERMISSION_RECEIVE_CONVERTED_TEXT)
    }
}