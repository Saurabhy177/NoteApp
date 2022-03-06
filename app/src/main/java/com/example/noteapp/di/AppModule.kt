package com.example.noteapp.di

import android.app.Application
import androidx.room.Room
import com.example.noteapp.feature_note.data.local.NoteDatabase
import com.example.noteapp.feature_note.data.repository.NoteRepoImpl
import com.example.noteapp.feature_note.domain.repository.NoteRepo
import com.example.noteapp.feature_note.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * The "InstallIn" annotation specifies for how long the injected dependencies will live.
 * Here, "SingletonComponent" class means all the dependencies live as long as our application.
 * */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * The "Singleton" annotation ensures there is only single instance throughout the whole
     * lifetime of our app.
     * */
    @Provides
    @Singleton
    fun providesNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNoteRepository(db: NoteDatabase): NoteRepo {
        return NoteRepoImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun providesNoteUseCases(repo: NoteRepo): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repo),
            deleteNoteUseCase = DeleteNoteUseCase(repo),
            addNoteUseCase = AddNoteUseCase(repo),
            getNoteUseCase = GetNoteUseCase(repo)
        )
    }
}