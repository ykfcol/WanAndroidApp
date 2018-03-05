package com.ykf.wandroid.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.qs.jzandroid.extension.sanitizeJson
import com.ykf.wandroid.api.WanApi
import com.ykf.wandroid.vo.Article
import com.ykf.wandroid.vo.Banner
import com.ykf.wandroid.vo.Resource

/**
 * Created by ykf on 18/2/28.
 */
class RecommendViewModel : BaseViewModel() {
    val page = 0
    val mArticleList = MutableLiveData<Resource<List<Article>>>()
    val mBannerList = MutableLiveData<Resource<List<Banner>>>()

    init {
        getArticleList()
        getBannerList()
    }

    fun getArticleList() {
        mCompositeDisposable.add(WanApi.create().getArticleList(page)
                .sanitizeJson()
                .doOnSubscribe { mArticleList.setValue(Resource.loading()) }
                .subscribe({
                    data ->
                    mArticleList.setValue(Resource.success(data?.datas))
                }, {
                    t ->
                    mArticleList.setValue(Resource.error(t))
                }
                ))

    }

    fun getBannerList() {
        mCompositeDisposable.add(WanApi.create().getBannerList()
                .sanitizeJson()
                .subscribe({
                    data ->
                    mBannerList.setValue(Resource.success(data))
                }, {
                    t ->
                    mBannerList.setValue(Resource.error(t))
                }
                ))
    }

}