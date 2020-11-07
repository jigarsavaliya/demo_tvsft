package com.demo.tvsft.adapter

import Data
import OutputModel
import Users
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter to show user data as per required
 */
class AdapterRepo(private val list:ArrayList<Users>) :

    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderRepo.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = list.get(position)
        (holder as ViewHolderRepo).bind(repoItem)
    }

    override fun getItemCount(): Int {
        return list.size;
    }

    public fun AddData(list:ArrayList<Users>){
        list.addAll(list);
    }

}