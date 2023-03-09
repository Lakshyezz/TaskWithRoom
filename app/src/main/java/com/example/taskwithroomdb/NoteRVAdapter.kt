package com.example.taskwithroomdb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter (val context: Context,
                     val noteClickInterface: NoteClickInterface,
                     val noteClickDeleteInterface: NoteClickDeleteInterface
                     ): RecyclerView.Adapter<NoteRVAdapter.ViewHolder>() {

    private val allNotes = ArrayList<Note>()

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val noteTv = itemView.findViewById<TextView>(R.id.tvNoteTitle)
        val timeTv = itemView.findViewById<TextView>(R.id.tvNoteTimeStamp)
        val deleteTv = itemView.findViewById<TextView>(R.id.ivDelete)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Get the layoutFile and inflate it
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_rv_item,parent,false)

    return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.noteTv.setText(allNotes[position].noteTitle)
        holder.timeTv.setText("Last Updated: " + allNotes[position].timeStamp)

        holder.deleteTv.setOnClickListener{
            noteClickDeleteInterface.onDeleteIconClick(allNotes[position])
        }
        holder.itemView.setOnClickListener{
            noteClickInterface.onNoteClick(allNotes[position])
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList: List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

}
interface NoteClickDeleteInterface{
    fun onDeleteIconClick(note: Note)
}
interface NoteClickInterface{
    fun onNoteClick(note: Note)
}
