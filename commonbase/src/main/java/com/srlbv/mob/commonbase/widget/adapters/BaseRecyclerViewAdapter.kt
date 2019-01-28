package com.srlbv.mob.commonbase.widget.adapters

import androidx.recyclerview.widget.RecyclerView

/**
 * Base Class for RecyclerView Adapters, all the general handling for adapter are done here, Like adding , appending ,removing Items etc.
 *
 * @param T Data type or model of adapter holding , an ArrayList<T> will be crated
 * @param V ViewHolder of the adapter
 * @property data initial data set for the adapter
 *@constructor Creates an RecyclerView.Adapter with provided data
 */
abstract class BaseRecyclerViewAdapter<T,V: RecyclerView.ViewHolder>(var data:ArrayList<T>?=null): RecyclerView.Adapter<V>()
{

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     *override from RecyclerView.Adapter
     *
     * @return The total number of items in this adapter. if data set is null returns 0
     */
    override fun getItemCount(): Int
    {
        return data?.size?:0
    }

    /**
     * Adds a single Item to data set
     * @param item item to be added to the data set
     */
    fun addItem(item:T)
    {
        if(data==null)
        {
            data= ArrayList()
        }
        data?.add(item)
        notifyDataSetChanged()
    }

    /**
     * Set data set
     * @param data data to be set
     */
    fun setItems(data:ArrayList<T>)
    {
        this.data?.clear()
        this.data=data
        notifyDataSetChanged()
    }

    /**
     * Appends data to existing data set
     *
     * @param data dato to be append
     */
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