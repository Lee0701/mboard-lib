package io.github.lee0701.mboard_lib.conversion

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.github.lee0701.mboard_lib.conversion.Constants.EXTRA_TEXT

/**
 * Converter side, receives request from mBoard
 * and pass it to the conversion engine
 */
class ConversionRequestBroadcastReceiver(
    val convert: (String) -> Unit
): BroadcastReceiver() {
    var broadcastReceived = false
    override fun onReceive(context: Context?, intent: Intent?) {
        context ?: return
        intent ?: return
        broadcastReceived = true
        val text = intent.getStringExtra(EXTRA_TEXT) ?: return
        convert(text)
    }
}