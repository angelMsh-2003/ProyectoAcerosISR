package io.devexpert.proyectoaceros.other

import android.content.Context
import android.widget.Toast

class AndroidNotifier(private val context: Context) : Notifier {
    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}