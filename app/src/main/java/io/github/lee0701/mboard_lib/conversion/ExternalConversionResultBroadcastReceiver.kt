package io.github.lee0701.mboard_lib.conversion

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.github.lee0701.mboard_lib.conversion.Constants.EXTRA_CANDIDATES

/**
 * mBoard side, receives conversion result
 * from Converter
 */
class ExternalConversionResultBroadcastReceiver(
    private val listener: Listener
): BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context ?: return
        intent ?: return
        val candidates = intent.getStringArrayListExtra(EXTRA_CANDIDATES)
            ?.map { it.split('\t') }.orEmpty()
        listener.onCandidates(candidates)
    }

    interface Listener {
        fun onCandidates(candidates: List<List<String>>)
    }
}