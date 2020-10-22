package com.vimal.comic.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vimal.comic.R
import com.vimal.comic.databinding.ComicListItemBinding
import com.vimal.comic.models.Comic
import com.vimal.core.ui.widget.adapters.BaseRecyclerViewAdapter

class ComicListAdapter(data:ArrayList<Comic>?=null) :
    BaseRecyclerViewAdapter<Comic, ComicListAdapter.ViewHolder>(data)
{
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder
    {
        val binding: ComicListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.comic_list_item,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int)
    {
        viewHolder.binding.comic=data?.get(index)
        viewHolder.binding.executePendingBindings()
    }

    class ViewHolder(val binding:ComicListItemBinding): RecyclerView.ViewHolder(binding.root)

}