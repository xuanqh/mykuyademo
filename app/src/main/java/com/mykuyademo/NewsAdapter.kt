package com.mykuyademo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mykuyademo.models.News


class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private lateinit var data: List<News>
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int {
        return if (::data.isInitialized) data.size else 0
    }

    fun updateData(data: List<News>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holderView = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)

        return ViewHolder(holderView)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvDemand: TextView = itemView.findViewById(R.id.tvTitle)
        var tvTitle: TextView = itemView.findViewById(R.id.tvDemand)
        var imgNews: ImageView = itemView.findViewById(R.id.imgNews)

        fun bind(news: News, position: Int){
            tvDemand.text = news.demand
            tvTitle.text = news.title
            if(position%2==0)
            {
                imgNews.setImageResource(R.drawable.news_1)
            }else{
                imgNews.setImageResource(R.drawable.news_2)
            }
        }
    }
}