package com.ykf.wandroid.viewmodel

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by ykf on 18/3/1.
 */
open class BaseViewModel : ViewModel() {
    val mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.clear()
    }
}