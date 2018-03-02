package com.ykf.wandroid.api

import android.util.Log
import com.ykf.wandroid.vo.ArticleData
import com.ykf.wandroid.vo.Banner
import io.reactivex.Observable
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by ykf on 18/2/28.
 */
interface WanApi {
    @GET("article/list/{page}/json")
    fun getArticleList(@Path("page") page: Int): Observable<ApiResponse<ArticleData>>

    @GET("banner/json")
    fun getBannerList(): Observable<ApiResponse<List<Banner>>>


    companion object {
        private const val BASE_URL = "http://www.wanandroid.com/"
        fun create(): WanApi = create(HttpUrl.parse(BASE_URL)!!)
        fun create(httpUrl: HttpUrl): WanApi {
            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                Log.d("API", it)
            })
            logger.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()
            return Retrofit.Builder()
                    .baseUrl(httpUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(WanApi::class.java)
        }
    }

}