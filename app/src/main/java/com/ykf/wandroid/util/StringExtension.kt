package com.qs.jzandroid.extension

import android.util.Log
import android.widget.Toast
import com.ykf.wandroid.App

/**
 * Created by ykf on 17/11/20.
 */

fun String.logD(TAG: String = "WanAndroid") {
    Log.d(TAG, this)
}

fun String.toast(length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(App.get(), this, length).show()
}


