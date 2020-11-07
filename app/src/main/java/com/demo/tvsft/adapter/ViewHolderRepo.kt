package com.demo.tvsft.adapter

import Users
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.tvsft.R


class ViewHolderRepo(view: View,val context:Context) : RecyclerView.ViewHolder(view) {

    private var repo: Users? = null

    private val name:TextView = view.findViewById(R.id.tv_user_name)
    private val ivdp: ImageView = view.findViewById(R.id.iv_user_dp)
    private val Items: RecyclerView = view.findViewById(R.id.rv_items)


    fun bind(repo: Users?) {
        if (repo == null) {
            val resources = itemView.resources

        } else {
            showRepoData(repo)
        }
    }

    private fun showRepoData(repos: Users) {
        this.repo = repos
        name.text=this.repo?.name;
        Glide.with(itemView).load(this.repo?.image).into(ivdp);
        val adapter = ImageAdapter(this.repo?.items as ArrayList<String>)

        val layoutManager = GridLayoutManager(context, 2)

        // Create a custom SpanSizeLookup where the first item spans both columns

        // Create a custom SpanSizeLookup where the first item spans both columns
        layoutManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position == 0) 2 else 1
            }
        }
        if (this.repo!!.items.size % 2 == 0)
            Items.layoutManager=GridLayoutManager(context, 2);
        else
            Items.layoutManager=GridLayoutManager(context, 1);

        Items.adapter=adapter;

    }

    companion object {
        fun create(parent: ViewGroup): ViewHolderRepo {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_user, parent, false)
            return ViewHolderRepo(view,context = parent.context)
        }
    }
}