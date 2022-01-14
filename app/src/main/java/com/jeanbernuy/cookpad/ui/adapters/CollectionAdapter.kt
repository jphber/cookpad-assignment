package com.jeanbernuy.cookpad.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jeanbernuy.cookpad.R
import com.jeanbernuy.cookpad.core.BaseViewHolder
import com.jeanbernuy.cookpad.data.model.Collection
import com.jeanbernuy.cookpad.data.model.Collections
import com.jeanbernuy.cookpad.databinding.ItemCollectionBinding

class CollectionAdapter(
    private val context: Context,
    private val collections: Collections,
    private val itemClickListener: OnCollectionClickListener
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnCollectionClickListener {
        fun onCollectionSelected(item: Collection)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ItemCollectionBinding.inflate(LayoutInflater.from(context), parent, false)
        return CollectionViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is CollectionViewHolder -> holder.bind(collections[position], position)
        }
    }

    override fun getItemCount(): Int {
        return collections.size
    }

    inner class CollectionViewHolder(private val binding: ItemCollectionBinding) :
        BaseViewHolder<Collection>(binding.root) {
        override fun bind(item: Collection, position: Int) = with(binding) {
            val itemImage = if (item.previewImageUrls.size > 0) item.previewImageUrls[0] else ""
            Glide.with(context).load(itemImage).centerCrop()
                .placeholder(R.drawable.ic_launcher_background).into(imvCollection)
            txtNameCollection.text = item.title
            txtDescription.text = item.description
            binding.root.setOnClickListener {
                itemClickListener.onCollectionSelected(item)
            }
        }

    }
}