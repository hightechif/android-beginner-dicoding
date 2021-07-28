package com.fadhil.musician.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fadhil.musician.dto.Musician
import com.fadhil.musician.R

class ListMusicianAdapter(private val listMusician: ArrayList<Musician>) : RecyclerView.Adapter<ListMusicianAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_musician, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val musician = listMusician[position]
        Glide.with(holder.itemView.context)
            .load(musician.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = musician.name
        holder.tvDescription.text = musician.description

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listMusician[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listMusician.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Musician)
    }
}