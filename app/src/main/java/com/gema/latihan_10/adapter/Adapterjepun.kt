package com.gema.latihan_10.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.gema.latihan_10.R

class AdapterJepun(
    private val context: Context,
    private val gambar: Array<Int>,
    private val judul: Array<String>,
    private val loc: Array<String>
) : BaseAdapter() {

    override fun getCount(): Int {
        return gambar.size
        return judul.size
        return loc.size
    }

    override fun getItem(position: Int): Any {
        return judul[position]

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.itemjepun, parent, false)
            viewHolder = ViewHolder()
            viewHolder.imageView = view.findViewById(R.id.imageView)
            viewHolder.judul = view.findViewById(R.id.JudulTempat)
            viewHolder.location = view.findViewById(R.id.lokasi)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        // Set data pada item
        viewHolder.imageView?.setImageResource(gambar[position])
        viewHolder.judul?.text = judul[position]
        viewHolder.location?.text = loc[position]

        return view
    }

    // ViewHolder pattern untuk mengoptimalkan performa
    private class ViewHolder {
        var imageView: ImageView? = null
        var judul: TextView? = null
        var location: TextView? = null
    }
}
