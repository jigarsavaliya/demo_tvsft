package com.demo.tvsft.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.tvsft.R

/**
 *      Created on 11/7/2020
 **/

internal class ImageAdapter(list:ArrayList<String>) :
    RecyclerView.Adapter<ImageAdapter.UserPostHolder>() {
    var postList: ArrayList<String> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPostHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_image, parent, false)
        return UserPostHolder(view)
    }

    override fun onBindViewHolder(holder: UserPostHolder, position: Int) {
        holder.bind(postList[position])

//        holder!!.retroId?.text=postList!!.get(position).getUserId()
//        holder!!.retroTitle?.text=postList!!.get(position).getTitle()
//        holder!!.retroBody.text=postList!!.get(position).getBody()
    }
    /*   override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserPostHolder {

           return UserPostHolder(LayoutInflater.from(parent?.context).inflate(R.layout.repo_list_item,parent,false))
       }

       override fun onBindViewHolder(holder: UserPostHolder?, position: Int) {
           holder!!.retroId?.text=postList!!.get(position).getUserId()
           holder!!.retroTitle?.text=postList!!.get(position).getTitle()
           holder!!.retroBody.text=postList!!.get(position).getBody()

       }*/

    override fun getItemCount(): Int {
        return postList.size
    }

    fun setListItems(postList: ArrayList<String>) {
        this.postList = postList
        notifyDataSetChanged()
    }

    class UserPostHolder(view: View) : RecyclerView.ViewHolder(view)
    {

        fun bind(item: String) {
            Glide.with(itemView).load("https://upload.wikimedia.org/wikipedia/commons/6/65/Baby.tux-800x800.png").placeholder(R.mipmap.ic_launcher).into(image);
        }

        val image:ImageView = view.findViewById(R.id.Iv_image)
    }


}