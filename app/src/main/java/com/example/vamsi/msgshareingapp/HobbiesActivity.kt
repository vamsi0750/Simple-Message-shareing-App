package com.example.vamsi.msgshareingapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_hobbies.*

class  HobbiesActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        val layoutManager =LinearLayoutManager(this)
        layoutManager.orientation=LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adpter =HobbiesAdpter(this,supplier.hobbies)
        recyclerView.adapter = adpter
    }

}


