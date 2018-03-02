package com.ykf.wandroid.vo

import android.arch.persistence.room.Entity
import com.google.gson.annotations.SerializedName

/**
 * Created by ykf on 18/2/28.
 */

@Entity(primaryKeys = arrayOf("id"))
data class Article(
		@SerializedName("apkLink")
		val apkLink: String,
		@SerializedName("author")
		val author: String, //小编
		@SerializedName("chapterId")
		val chapterId: Int, //272
		@SerializedName("chapterName")
		val chapterName: String, //常用网站
		@SerializedName("collect")
		val collect: Boolean, //false
		@SerializedName("courseId")
		val courseId: Int, //13
		@SerializedName("desc")
		val desc: String,
		@SerializedName("envelopePic")
		val envelopePic: String,
		@SerializedName("id")
		val id: Int, //2405
		@SerializedName("link")
		val link: String, //https://dl.google.com/dl/android/maven2/index.html
		@SerializedName("niceDate")
		val niceDate: String, //2018-02-25
		@SerializedName("origin")
		val origin: String,
		@SerializedName("projectLink")
		val projectLink: String,
		@SerializedName("publishTime")
		val publishTime: Long, //1519537704000
		@SerializedName("title")
		val title: String, //google mvn仓库
		@SerializedName("visible")
		val visible: Int, //1
		@SerializedName("zan")
		val zan: Int //0
)