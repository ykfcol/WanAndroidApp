package com.ykf.wandroid.ui.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by ykf on 18/3/2.
 */
class BaseViewHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)