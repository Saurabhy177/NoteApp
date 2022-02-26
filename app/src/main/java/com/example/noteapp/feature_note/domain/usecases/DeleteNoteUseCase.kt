package com.example.noteapp.feature_note.domain.usecases

import com.example.noteapp.feature_note.domain.model.Note
import com.example.noteapp.feature_note.domain.repository.NoteRepo

class DeleteNoteUseCase(
    private val repo: NoteRepo
) {

    suspend operator fun invoke(note: Note) {
        repo.deleteNote(note)
    }
}