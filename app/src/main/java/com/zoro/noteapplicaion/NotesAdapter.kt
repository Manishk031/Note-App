package com.zoro.noteapplicaion

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import androidx.recyclerview.widget.RecyclerView.Recycler

class NotesAdapter (private var note: List<Note>, context:Context):
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = note.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = note[position]
        holder.titleTextView.text = note.title
        holder.contentTextView.text = note.content
    }
    fun refreshData(newNote:List<Note>){
        note = newNote
        notifyDataSetChanged()
    }
}