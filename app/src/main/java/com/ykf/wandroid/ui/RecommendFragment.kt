package com.ykf.wandroid.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ykf.wandroid.R
import com.ykf.wandroid.databinding.FragmentRecommendBinding
import com.ykf.wandroid.ui.adapter.ArticleAdapter
import com.ykf.wandroid.util.GlideImageLoader
import com.ykf.wandroid.viewmodel.RecommendViewModel
import com.youth.banner.Banner
import com.youth.banner.BannerConfig

/**
 * Created by ykf on 18/2/28.
 */
class RecommendFragment : Fragment() {

    private lateinit var binding: FragmentRecommendBinding
    private lateinit var model: RecommendViewModel

    private lateinit var banner: Banner
    val mArticleAdapter = ArticleAdapter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recommend, container, false)
        binding.rv.adapter = mArticleAdapter
        binding.rv.itemAnimator = null
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val headerView = LayoutInflater.from(context).inflate(R.layout.header_banner, binding.root as ViewGroup, false)
        banner = headerView.findViewById<Banner>(R.id.banner)
        mArticleAdapter.addHeaderView(headerView)

        model = ViewModelProviders.of(this).get(RecommendViewModel::class.java)

        model.mArticleList.observe(this, Observer {
            mArticleAdapter.setArticleList(it?.data)
            binding.resource = it
            binding.executePendingBindings()
        })

        model.mBannerList.observe(this, Observer {
            val images = mutableListOf<String>()
            val titles = mutableListOf<String>()
            it?.data?.forEach {
                t ->
                images.add(t.imagePath)
                titles.add(t.title)
            }
            banner.setImages(images)
                    .setBannerTitles(titles)
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                    .setImageLoader(GlideImageLoader())
                    .start()
        })

        binding.swipeLayout.setOnRefreshListener { model.getArticleList() }
    }


}