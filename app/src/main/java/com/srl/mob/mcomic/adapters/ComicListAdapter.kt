package com.srl.mob.mcomic.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.srl.mob.mcomic.R
import com.srl.mob.mcomic.databinding.ComicListItemBinding
import com.srl.mob.mcomic.model.Comic

/**
 * Adapter for list comics Child class of BaseRecyclerViewAdapter
 * @see BaseRecyclerViewAdapter
 * @property data initial data for adapter
 * @property callBack ItemClickCallBack interface object
 */
class ComicListAdapter(data:ArrayList<Comic>?=null,val callBack:ItemClickCallBack<Comic>?=null) :BaseRecyclerViewAdapter<Comic,ComicListAdapter.ViewHolder>(data)
{
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder
    {
        val binding:ComicListItemBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.comic_list_item,parent,false)
        binding.callback=callBack
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int)
    {
        viewHolder.binding.comic=data?.get(index)
        viewHolder.binding.executePendingBindings()
    }

    class ViewHolder(val binding:ComicListItemBinding): RecyclerView.ViewHolder(binding.root)

}