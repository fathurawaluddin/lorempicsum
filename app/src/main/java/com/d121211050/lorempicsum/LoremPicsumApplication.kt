package com.d121211050.lorempicsum;

import android.app.Application
import com.d121211050.lorempicsum.data.AppContainer
import com.d121211050.lorempicsum.data.DefaultAppContainer

class LoremPicsumApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
        }
    }
