package com.ykf.wandroid.ui.adapter

import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qs.jzandroid.extension.toast
import com.ykf.wandroid.R
import com.ykf.wandroid.databinding.ItemArticleBinding
import com.ykf.wandroid.vo.Article

/**
 * Created by ykf on 18/2/28.
 */
class ArticleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mArticleList: List<Article>? = null

    private var mHeaderView: View? = null

    private val ITEM_HEADER = 111
    private val ITEM_CONTENT = 222

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ArticleViewHolder) {
            holder.binding.article = mArticleList!![position-1]
            holder.binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (mHeaderView != null && viewType == ITEM_HEADER) return HeaderViewHolder(mHeaderView!!)
        var binding: ItemArticleBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_article, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        if (mHeaderView != null) return if (mArticleList == null) 1 else mArticleList!!.size + 1
        return if (mArticleList == null) 0 else mArticleList!!.size
    }


    override fun getItemViewType(position: Int): Int {
        if (mHeaderView != null && position == 0) return ITEM_HEADER
        return ITEM_CONTENT
    }

    fun addHeaderView(view: View) {
        mHeaderView = view
    }


    class ArticleViewHolder(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root)
    class HeaderViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setArticleList(articles: List<Article>?) {
        if (articles == null) {
            return
        }
        if (mArticleList == null) {
            mArticleList = articles
            notifyDataSetChanged()
            /*notifyItemRangeInserted(0, articles.size)*/
        } else {
            val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun getOldListSize(): Int {
                    return mArticleList!!.size
                }

                override fun getNewListSize(): Int {
                    return articles.size
                }

                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val old = mArticleList!![oldItemPosition]
                    val article = articles[newItemPosition]
                    return old.id === article.id
                }

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val old = mArticleList!![oldItemPosition]
                    val article = articles[newItemPosition]
                    return old.id === article.id
                            && old.author === article.author
                            && old.title === article.title
                            && old.chapterName == article.chapterName
                }
            })
            mArticleList = articles
            diffResult.dispatchUpdatesTo(this)
        }
    }


}
