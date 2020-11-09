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

            showRepoData(repo!!)

    }

    /**
     * Data set ousers in this mathod
     * in this we have implement custome span logic depend on size of array
     */
    private fun showRepoData(repos: Users) {
        this.repo = repos
        name.text=this.repo?.name;
        Glide.with(itemView).load(this.repo?.image).placeholder(R.mipmap.ic_launcher).into(ivdp);
        val adapter = ImageAdapter(this.repo?.items as ArrayList<String>)

        if(Items.layoutManager == null) {
            val layoutManager = GridLayoutManager(context, 2)


            layoutManager.spanSizeLookup = object : SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    if (repo!!.items.size % 2 == 0)
                        return 1;
                    else
                        return if (position == 0) 2 else 1

                }
            }

            Items.layoutManager = layoutManager;
            Items.adapter = adapter;
        }



    }

    companion object {
        fun create(parent: ViewGroup): ViewHolderRepo {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_user, parent, false)
            return ViewHolderRepo(view,context = parent.context)
        }
    }
}