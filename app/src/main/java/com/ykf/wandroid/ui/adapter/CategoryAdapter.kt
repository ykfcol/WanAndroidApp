package com.ykf.wandroid.ui.adapter

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ykf.wandroid.R
import com.ykf.wandroid.databinding.ItemCategoryBinding
import com.ykf.wandroid.vo.Category

/**
 * Created by ykf on 18/3/2.
 */
class CategoryAdapter : BaseAdapter<Category, ItemCategoryBinding>() {
    override fun bind(binding: ItemCategoryBinding, item: Category) {
        binding.category = item
    }

    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id && oldItem.name == newItem.name
    }

    override fun createBinding(parent: ViewGroup): ItemCategoryBinding {
        val binding: ItemCategoryBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_category, parent, false)
        return binding
    }

}