package io.devexpert.proyectoaceros.other

import android.app.Activity
class AndroidAppCloser (private val activity: Activity) : AppCloser{
    override fun closeApp () {
        activity.finishAffinity()
    }
}