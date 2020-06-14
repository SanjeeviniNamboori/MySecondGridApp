package com.example.mysecondgridapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.grid_item.view.*

class CustomAdapter(context: Context, arrayListImage: ArrayList<Int>,name: Array<String>) : BaseAdapter() {

    var context = context
    var arrayListImage =  arrayListImage
    var name = name

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var myView = convertView
        var holder : ViewHolder

        if(myView == null){
            val mInflater = (context as Activity).layoutInflater

            myView = mInflater.inflate(R.layout.grid_item, parent, false)



            holder = ViewHolder()

            holder.mImageView = myView!!.findViewById<ImageView>(R.id.imageView) as ImageView
            holder.mTextView = myView!!.findViewById<ImageView>(R.id.textView) as TextView

            myView.setTag(holder)

       /*     myView.imageView.setOnClickListener{

                val intent = Intent(context, ItemDetails::class.java)
                intent.putExtra("name" , name)
                intent.putExtra("image", arrayListImage)

                context!!.startActivity(intent)
            } */
        }else{
            holder = myView.getTag() as ViewHolder
        }
    holder.mImageView!!.setImageResource(arrayListImage.get(position))
        holder.mTextView!!.setText(name.get(position))
        return myView
    }

    override fun getItem(position: Int): Any {
        return arrayListImage.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return arrayListImage.size
    }

    class ViewHolder{
        var mImageView: ImageView? = null
        var mTextView: TextView? = null
    }
}