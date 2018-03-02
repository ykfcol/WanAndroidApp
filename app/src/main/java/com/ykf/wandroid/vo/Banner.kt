package com.ykf.wandroid.vo

/**
 * Created by ykf on 18/3/1.
 */

data class Banner(
		val desc: String,
		val id: Int, //6
		val imagePath: String, //http://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png
		val isVisible: Int, //1
		val order: Int, //1
		val title: String, //我们新增了一个常用导航Tab~
		val type: Int, //0
		val url: String //http://www.wanandroid.com/navi
)