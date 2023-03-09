package com.example.taskwithroomdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import java.text.SimpleDateFormat
import java.util.Date

class AddEditNoteActivity : AppCompatActivity() {
    lateinit var noteTitleEdit: EditText
    lateinit var noteDescription: EditText
    lateinit var addUpdateBtn: Button

    lateinit var viewModel: NoteViewModel
    var noteID = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)
        noteTitleEdit = findViewById(R.id.editNoteTitle)
        noteDescription = findViewById(R.id.editNoteDescription)
        addUpdateBtn = findViewById(R.id.btnAddUpdate)
        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)

        val noteType = intent.getStringExtra("noteType")
        if(noteType.equals("Edit")){
            val  noteTitle = intent.getStringExtra("noteTitle")
            val  noteDesc = intent.getStringExtra("noteDescription")
            noteID = intent.getIntExtra("noteID",-1)
            addUpdateBtn.setText("Update Note")

            noteTitleEdit.setText(noteTitle)
            noteDescription.setText(noteDesc)
        }else{

            addUpdateBtn.setText("Save")
        }

        addUpdateBtn.setOnClickListener{
            val noteTitle = noteTitleEdit.text.toString()
            val noteDescripton = noteDescription.text.toString()

            if(noteType.equals("Edit")){
                if(noteTitle.isNotEmpty() && noteDescripton.isNotEmpty()){
                    val sdf = SimpleDateFormat("dd MMM, yyyy -HH:mm")
                    val currentDate:String = sdf.format(Date())

                    val updatedNote = Note(noteTitle,noteDescripton,currentDate)
                    updatedNote.id = noteID
                    viewModel.updateNode(updatedNote)

                    Toast.makeText(this,"Note Updated.." , Toast.LENGTH_SHORT).show()

                }
            }else{
                if(noteTitle.isNotEmpty() && noteDescripton.isNotEmpty()){
                    val sdf = SimpleDateFormat("dd MMM, yyyy -HH:mm")
                    val currentDate:String = sdf.format(Date())

                   viewModel.insertNote( Note(noteTitle,noteDescripton,currentDate))


                    Toast.makeText(this,"Note Added.." , Toast.LENGTH_SHORT).show()

                }
            }
            startActivity(Intent(applicationContext, MainActivity::class.java))
            this.finish()
        }
    }

}