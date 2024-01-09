package com.zoro.noteapplicaion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zoro.noteapplicaion.databinding.ActivityAddNoteBinding

import com.zoro.noteapplicaion.databinding.ActivityUpdateNoteBinding

class UpdateNoteActivity : AppCompatActivity() {

    private lateinit var binding:ActivityUpdateNoteBinding
    private lateinit var db : NoteDatabaseHelper
    private var noteId : Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = NoteDatabaseHelper(this)


        noteId = intent.getIntExtra("note_id",-1)
         if (noteId == -1)
         {
             finish()
             return
         }

        val note = db.getNoteByID(noteId)
        binding.UpdateTitleEditText.setText(note.title)
        binding.UpdateContentEditText.setText(note.content)
              binding.updateSaveButton.setOnClickListener{
                  val newTitle = binding.UpdateTitleEditText.text.toString()
                  val newContent = binding.UpdateContentEditText.text.toString()
                  val updatedNote = Note(noteId,newTitle,newContent)

                  db.updateNote(updatedNote)
                  finish()

                  Toast.makeText(this,"Change Saved",Toast.LENGTH_SHORT).show()
              }
    }
}