package com.example.enishop.ui.articlelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.enishop.bo.Article
import com.example.enishop.databinding.TemplateArticleLineBinding

class ArticleAdapter(var articles: List<Article>, val listener: (article: Article) -> Unit) :
    Adapter<ArticleAdapter.ArticleVH>() {
    class ArticleVH(val binding: TemplateArticleLineBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleVH {
        val binding = TemplateArticleLineBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ArticleVH(binding)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleVH, position: Int) {
        holder.binding.article = articles[position]
        //itemView qui permet d'accéder au container de l'item
        holder.itemView.setOnClickListener {
            listener.invoke(articles[position])
        }
    }

}