package com.demo.tvsft.adapter

import Data
import OutputModel
import Users
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.tvsft.R

class ViewHolderRepo(view: View) : RecyclerView.ViewHolder(view) {

    private var repo: Users? = null

    init {

    }

    fun bind(repo: Users?) {
        if (repo == null) {
            val resources = itemView.resources

        } else {
            showRepoData(repo)
        }
    }

    private fun showRepoData(repo: Users) {
        this.repo = repo

    }

    companion object {
        fun create(parent: ViewGroup): ViewHolderRepo {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_user, parent, false)
            return ViewHolderRepo(view)
        }
    }
}