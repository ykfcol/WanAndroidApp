package com.ykf.wandroid.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.qs.jzandroid.extension.sanitizeJson
import com.ykf.wandroid.api.WanApi
import com.ykf.wandroid.vo.HotKey
import com.ykf.wandroid.vo.Resource

/**
 * Created by ykf on 18/3/3.
 */
class HotSearchViewModel : BaseViewModel() {


    val mHotKeys = MutableLiveData<Resource<List<HotKey>>>()

    init {
        getHotKey()
    }

    fun getHotKey() {
        mCompositeDisposable.add(WanApi.create().getHotKey()
                .sanitizeJson()
                .subscribe({
                    data -> mHotKeys.value = Resource.success(data)
                }, {
                    t -> mHotKeys.value = Resource.error(t)
                }))
    }

}