package com.ykf.wandroid

import android.app.Application

/**
 * Created by ykf on 18/3/1.
 */
class App : Application() {

    companion object {
        private lateinit var INSTANCE: App
        fun get(): App {
            return INSTANCE
        }

    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}