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
import com.ykf.wandroid.databinding.FragmentHotSearchBinding
import com.ykf.wandroid.viewmodel.HotSearchViewModel
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import android.widget.TextView
import com.qs.jzandroid.extension.toast


/**
 * Created by ykf on 18/3/3.
 */
class HotSearchFragment : Fragment() {

    private lateinit var binding: FragmentHotSearchBinding
    private lateinit var model: HotSearchViewModel

    private val mValues = listOf("111", "222", "333", "444", "555")

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hot_search, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        model = ViewModelProviders.of(this).get(HotSearchViewModel::class.java)

        model.mHotKeys.observe(this, Observer {

        })

        "master".toast()

        "dev".toast()
        "dev".toast()
        "dev".toast()
        "dev".toast()
        "dev".toast()
        "master".toast()


        binding.flHot.setOnTagClickListener { p0, p1, p2 -> true }

        binding.flHot.adapter = object : TagAdapter<String>(mValues) {
            override fun getView(parent: FlowLayout, position: Int, s: String): View {
                val tv = LayoutInflater.from(context).inflate(R.layout.item_flow,
                        binding.flHot, false) as TextView
                tv.text = s
                return tv
            }

        }

        binding.flNormal.adapter = object : TagAdapter<String>(mValues) {
            override fun getView(p0: FlowLayout?, p1: Int, s: String?): View {
                val tv = LayoutInflater.from(context).inflate(R.layout.item_flow,
                        binding.flHot, false) as TextView
                tv.text = s
                return tv
            }
        }


    }
}