package com.srl.mob.mcomic.adapters

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T,V: RecyclerView.ViewHolder>(var data:ArrayList<T>?=null): RecyclerView.Adapter<V>()
{

    override fun getItemCount(): Int
    {
        return data?.size?:0
    }

    fun addItem(item:T)
    {
        if(data==null)
        {
            data= ArrayList()
        }
        data?.add(item)
        notifyDataSetChanged()
    }

    fun setItems(data:ArrayList<T>)
    {
        this.data?.clear()
        this.data=data
        notifyDataSetChanged()
    }

    fun addAll(data: ArrayList<T>)
    {
        if(this.data==null)
        {
            setItems(data)
        }
        else
        {
            this.data?.addAll(data)
        }
        notifyDataSetChanged()
    }
}