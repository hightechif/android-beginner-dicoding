package com.fadhil.musician.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fadhil.musician.model.Musician
import com.fadhil.musician.R
import timber.log.Timber

class MusicianAdapter(private val musicianList: ArrayList<Musician>) : RecyclerView.Adapter<MusicianAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_musician, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val musician = musicianList[position]
        Timber.i("onBindViewHolder: $musician")
        Glide.with(holder.itemView.context)
            .load(musician.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = musician.name
        holder.tvDescription.text = musician.description

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(musicianList[holder.bindingAdapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return musicianList.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Musician)
    }
}