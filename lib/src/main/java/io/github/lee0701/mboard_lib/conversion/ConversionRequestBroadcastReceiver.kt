package io.github.lee0701.mboard_lib.conversion

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.github.lee0701.mboard_lib.conversion.Constants.ACTION_CONVERT_TEXT
import io.github.lee0701.mboard_lib.conversion.Constants.ACTION_UPDATE_CONTEXT_TEXT
import io.github.lee0701.mboard_lib.conversion.Constants.EXTRA_TEXT

/**
 * Converter side, receives request from mBoard
 * and pass it to the conversion engine
 */
class ConversionRequestBroadcastReceiver(
    private val listener: Listener
): BroadcastReceiver() {
    var broadcastReceived = false
    override fun onReceive(context: Context?, intent: Intent?) {
        context ?: return
        intent ?: return
        when(intent.action) {
            ACTION_CONVERT_TEXT -> {
                val text = intent.getStringExtra(EXTRA_TEXT) ?: return
                listener.onConvertText(text)
            }
            ACTION_UPDATE_CONTEXT_TEXT -> {
                val text = intent.getStringExtra(EXTRA_TEXT ) ?: return
                listener.onUpdateContextText(text)
            }
            else -> return
        }
        broadcastReceived = true
    }

    interface Listener {
        fun onConvertText(text: String)
        fun onUpdateContextText(text: String)
    }
}