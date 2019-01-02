package com.srl.mob.mcomic.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.srl.mob.mcomic.R
import com.srl.mob.mcomic.model.Comic
import kotlinx.android.synthetic.main.comic_list_item.view.*

class ComicListAdapter(data:ArrayList<Comic>?=null) :BaseRecyclerViewAdapter<Comic,ComicListAdapter.ViewHolder>(data)
{
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder
    {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.comic_list_item, parent, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int)
    {
        viewHolder.view.comic_img.setImageURI(data?.get(index)?.thumbnail?.getUrl()?:"")
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

}