package com.ykf.wandroid.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ykf.wandroid.R
import com.ykf.wandroid.databinding.FragmentCategoryBinding
import com.ykf.wandroid.ui.adapter.CategoryAdapter
import com.ykf.wandroid.viewmodel.CategoryViewModel

/**
 * Created by ykf on 18/3/2.
 */
class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding
    private lateinit var model: CategoryViewModel

    private val mCategoryAdapter = CategoryAdapter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category, container, false)
        binding.rv.adapter = mCategoryAdapter
        binding.rv.itemAnimator = null
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        model.mCategoryList.observe(this, Observer {
            if (it?.data != null) mCategoryAdapter.replace(it?.data)
            binding.resource = it
            binding.executePendingBindings()
        })
        binding.swipeLayout.setOnRefreshListener { model.getCategoryList() }
    }
}