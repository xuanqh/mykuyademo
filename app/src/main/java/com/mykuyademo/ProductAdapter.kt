package com.mykuyademo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mykuyademo.models.Product


class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private lateinit var data: List<Product>
    var isExpandList = false
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return if (::data.isInitialized) {
            if (isExpandList) {
                data.size
            } else {
                if (data.size < 6) {
                    if (::data.isInitialized) data.size else 0
                } else {
                    6
                }
            }
        }else{
            isExpandList = false
            0
        }
    }

    fun updateExpandList(){
        isExpandList = !isExpandList
        notifyDataSetChanged()
    }

    fun updateData(data: List<Product>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holderView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)

        return ViewHolder(holderView)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvName)
        var imgProduct: ImageView = itemView.findViewById(R.id.imProduct)

        fun bind(product: Product){
            tvName.text = product.name
            imgProduct.setImageResource(imgProduct.resources.getIdentifier(product.image_name, "drawable", imgProduct.context.packageName))
        }
    }
}