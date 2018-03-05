package com.ykf.wandroid.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.qs.jzandroid.extension.sanitizeJson
import com.ykf.wandroid.api.WanApi
import com.ykf.wandroid.vo.Category
import com.ykf.wandroid.vo.Resource

/**
 * Created by ykf on 18/3/2.
 */
class CategoryViewModel : BaseViewModel() {

    val mCategoryList = MutableLiveData<Resource<List<Category>>>()

    init {
        getCategoryList()
    }

    fun getCategoryList() {
        mCompositeDisposable.add(WanApi.create()
                .getCategoryList()
                .sanitizeJson()
                .doOnSubscribe { mCategoryList.value = Resource.loading() }
                .subscribe({
                   data -> mCategoryList.value = Resource.success(data)
                }, {
                    t -> mCategoryList.value = Resource.error(t)
                }))
    }
}