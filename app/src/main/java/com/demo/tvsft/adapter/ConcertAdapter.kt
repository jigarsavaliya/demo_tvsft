package com.demo.tvsft.adapter

import androidx.recyclerview.widget.RecyclerView

class ConcertAdapter() :
        RecyclerView.Adapter<Concert, ConcertViewHolder>(DIFF_CALLBACK) {
    fun onBindViewHolder(holder: ConcertViewHolder, position: Int) {
        val concert: Concert? = getItem(position)

        // Note that "concert" is a placeholder if it's null.
        holder.bindTo(concert)
    }

    companion object {
        private val DIFF_CALLBACK = object :
                DiffUtil.ItemCallback<Concert>() {
            // Concert details may have changed if reloaded from the database,
            // but ID is fixed.
            override fun areItemsTheSame(oldConcert: Concert,
                    newConcert: Concert) = oldConcert.id == newConcert.id

            override fun areContentsTheSame(oldConcert: Concert,
                    newConcert: Concert) = oldConcert == newConcert
        }
    }
}