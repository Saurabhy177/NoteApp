package com.example.noteapp.feature_note.domain.usecases

import com.example.noteapp.feature_note.domain.model.Note
import com.example.noteapp.feature_note.domain.repository.NoteRepo

class GetNoteUseCase(
    private val repo: NoteRepo
) {

    suspend operator fun invoke(id: Int): Note? {
        return repo.getNoteById(id)
    }
}