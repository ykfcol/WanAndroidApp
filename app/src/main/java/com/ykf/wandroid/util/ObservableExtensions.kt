package com.qs.jzandroid.extension

import com.ykf.wandroid.api.ApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.Observable

fun <T> Observable<ApiResponse<T>>.sanitizeJson(): Observable<T> = this
        .subscribeOn(Schedulers.io())
        .flatMap { response ->
            if (response.errorCode == 0) {
                Observable.just(response.data!!)
            } else {
                Observable.error(Throwable(response.errorMsg))
            }
        }
        .observeOn(AndroidSchedulers.mainThread())


/*
fun <T> Flowable<BaseResponse<T>>.sanitizeJson(): Flowable<T> = this
        .subscribeOn(Schedulers.io())
        .flatMap { response ->
            if (response.code == "success") {
                if (response.data == null) {
                    Flowable.error(ApiException(response.message))
                } else {
                    createData(response.data!!)
                }
            } else {
                if (response.code == "appToken") {
                    */
/*App.get().finishAllActivity()
                    Intent(App.get(), LoginActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        App.get().startActivity(this)
                    }*//*

                    Flowable.error(ApiException("登录超时"))
                } else {
                    Flowable.error(ApiException(response.message))
                }
            }
        }
        .observeOn(AndroidSchedulers.mainThread())


fun <T> createData(data: T): Flowable<T> {
    return Flowable.create({ e ->
        try {
            Log.d("api", "subscribe: " + data.toString())
            e.onNext(data)
            e.onComplete()
        } catch (exception: Exception) {
            e.onError(exception)
        }
    }, BackpressureStrategy.BUFFER)
}*/
