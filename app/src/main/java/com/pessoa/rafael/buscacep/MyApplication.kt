package com.pessoa.rafael.buscacep

import com.facebook.stetho.Stetho
import android.app.Application


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}