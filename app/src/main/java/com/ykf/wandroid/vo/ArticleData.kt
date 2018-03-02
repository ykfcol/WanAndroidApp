package com.ykf.wandroid.vo

/**
 * Created by ykf on 18/2/28.
 */

data class ArticleData(
		val curPage: Int, //1
		val datas: List<Article>,
		val offset: Int, //0
		val over: Boolean, //false
		val pageCount: Int, //54
		val size: Int, //20
		val total: Int //1072
)

