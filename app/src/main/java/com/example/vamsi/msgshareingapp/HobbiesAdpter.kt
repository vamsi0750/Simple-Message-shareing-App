package com.example.vamsi.msgshareingapp

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.vamsi.msgshareingapp.R.id.etUserMessage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*


class HobbiesAdpter( val context: Context, val hobbies: List<Hobby>): RecyclerView.Adapter<HobbiesAdpter.myViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): myViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, p0, false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(p0: myViewHolder, p1: Int) {
        val hobby = hobbies[p1]
        p0.setData(hobby,p1)
    }

    inner  class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var currentHobby: Hobby? =null
        var currentPosition: Int=0

        init {
            itemView.setOnClickListener{
                Toast.makeText(context,currentHobby!!.title  + " Clicked !",Toast.LENGTH_SHORT).show()
            }

            itemView.imgShare.setOnClickListener {
                val message: String = "My Hobbies Are : "  + currentHobby!!.title

                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,message)
                intent.type="text/plain"
                context.startActivity(Intent.createChooser(intent,"Share To"))

            }
        }

        fun setData(hobby: Hobby?,p1: Int )  {
                itemView.txvTitle.text =hobby!!.title

            this.currentHobby = hobby
            this.currentPosition = p1
        }

     }
}