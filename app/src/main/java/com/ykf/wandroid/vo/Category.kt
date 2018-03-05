package com.ykf.wandroid.vo

/**
 * Created by ykf on 18/3/2.
 */

data class Category(
		val children: List<Children>,
		val courseId: Int, //13
		val id: Int, //150
		val name: String, //开发环境
		val order: Int, //1
		val parentChapterId: Int, //0
		val visible: Int //1
) {
	fun getChildName(): String {
		val childName = StringBuilder("")
		children.forEach { childName.append("${it.name}   ") }
		return childName.toString()
	}
}

data class Children(
		val children: List<Any>,
		val courseId: Int, //13
		val id: Int, //60
		val name: String, //Android Studio相关
		val order: Int, //1000
		val parentChapterId: Int, //150
		val visible: Int //1
)