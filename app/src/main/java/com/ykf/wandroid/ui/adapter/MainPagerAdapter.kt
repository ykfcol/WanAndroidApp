package com.ykf.wandroid.ui.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.ykf.wandroid.ui.CategoryFragment
import com.ykf.wandroid.ui.HotSearchFragment
import com.ykf.wandroid.ui.RecommendFragment

/**
 * Created by ykf on 18/2/28.
 */
class MainPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    val tabTitles = listOf("推荐", "体系", "导航", "项目", "工具")

    override fun getItem(position: Int) =
            when (position) {
                0 -> RecommendFragment()
                1 -> CategoryFragment()
                2 -> HotSearchFragment()
                else -> CategoryFragment()
            }

    override fun getCount() = tabTitles.size

    override fun getPageTitle(position: Int) = tabTitles[position]


}