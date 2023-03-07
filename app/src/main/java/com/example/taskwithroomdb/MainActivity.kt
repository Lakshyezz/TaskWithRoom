package com.example.taskwithroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
   lateinit var addButton: FloatingActionButton
    lateinit var notesRV: RecyclerView
//    lateinit var mBinding: MainActivityBi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addButton = findViewById(R.id.idFABaddNote)
        notesRV = findViewById(R.id.rvNotes)
    }
}