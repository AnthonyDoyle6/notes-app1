package controllers

import models.Note
import persistence.JSONSerializer
import persistence.Serializer
import java.io.File

class NoteAPI(serializerType: Serializer) {
    private var notes = ArrayList<Note>()
    //private val noteAPI = NoteAPI(XMLSerializer(File("notes.xml")))
    private val noteAPI = NoteAPI(JSONSerializer(File("notes.json")))
    fun add (note: Note): Boolean {
        return notes.add(note)
    }
        fun listAllNotes(): String {
            return if (notes.isEmpty()) {
                "No Notes Returned"
            } else{
                var listOfNotes = ""
                for (i in notes.indices) {
                    listOfNotes += "${i}: ${notes[i]} \n"
                }
                  listOfNotes
            }
        }
    fun numberOfNotes(): Int {
        return notes.size
    }

    fun findNote(index: Int): Note? {
        return if (isValidListIndex(index, notes)) {
            notes[index]
        } else null
    }

    //utility method to determine if an index is valid in a list.
    fun isValidListIndex(index: Int, list: List<Any>): Boolean {
        return (index >= 0 && index < list.size)
    }
    fun deleteNote(indexToDelete: Int): Note? {
        return if (isValidListIndex(indexToDelete, notes)) {
            notes.removeAt(indexToDelete)
        } else null
    }

    fun updateNote(indexToUpdate: Int, note: Note?): Boolean {
        //find the note object by the index number
        val foundNote = findNote(indexToUpdate)

        //if the note exists, use the note details passed as parameters to update the found note in the ArrayList.
        if ((foundNote != null) && (note != null)) {
            foundNote.noteTitle = note.noteTitle
            foundNote.notePriority = note.notePriority
            foundNote.noteCategory = note.noteCategory
            return true
        }

        //if the note was not found, return false, indicating that the update was not successful
        return false
    }

    fun isValidIndex(index: Int) :Boolean{
        return isValidListIndex(index, notes);
    }

    @Throws(Exception::class)
    fun load() {
        notes = serializer.read() as ArrayList<Note>
    }

    @Throws(Exception::class)
    fun store() {
        serializer.write(notes)
    }
}
