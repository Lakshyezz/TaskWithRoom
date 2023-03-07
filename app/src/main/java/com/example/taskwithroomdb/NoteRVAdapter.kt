package com.example.taskwithroomdb

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter (val context: Context,): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val noteTv = itemView.findViewById<TextView>(R.id.tvNoteTitle)
        val timeTv = itemView.findViewById<TextView>(R.id.tvNoteTimeStamp)
        val deleteTv = itemView.findViewById<TextView>(R.id.ivDelete)

    }

    interface onclickDeleteInterface{
        fun onDeleteIconClick(note: Note)
    }
    interface onclickInterface{
        fun onNoteClick(note: Note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}