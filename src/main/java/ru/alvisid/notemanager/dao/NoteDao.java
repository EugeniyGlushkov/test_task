package ru.alvisid.notemanager.dao;

import ru.alvisid.notemanager.model.Note;

import java.util.List;

public interface NoteDao {
    void addNote(Note note);

    void updateNote(Note note);

    void removeNote(int id);

    Note getNoteById(int id);

    List<Note> listNotes(int numPage, String qwery);

    int getAmountPages(String qwery);
}
