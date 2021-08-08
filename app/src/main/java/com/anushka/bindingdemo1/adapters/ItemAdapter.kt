package com.anushka.bindingdemo1.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anushka.bindingdemo1.R
import com.squareup.picasso.Callback
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import kotlinx.coroutines.NonDisposableHandle.parent


class ItemAdapter(val context: Context, val items: ArrayList<String>): RecyclerView.Adapter<ItemAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        return ItemAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.stag_grid_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        val item: String = items[position]




        Picasso.with(context).load(item).networkPolicy(NetworkPolicy.OFFLINE)
            .into(holder.imageview, object : Callback {
                override fun onSuccess() {

                    print("Success Caching")
                }
                override fun onError() {
                    Picasso.with(context).load(item )
                        .into(holder.imageview)
                }
            })
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val imageview = view.findViewById(R.id.Image_Dog) as ImageView
            //var image = view.Image_Dog
            //var grid = view.griditem

    }
}