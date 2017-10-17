package ru.alvisid.notemanager.service;

import ru.alvisid.notemanager.model.Note;

import java.io.Serializable;
import java.util.List;

public interface NoteService {
    void addNote(Note note);

    void updateNote(Note note);

    void removeNote(int id);

    Note getNoteById(int id);

    List<Note> listNotes();

    int amountPages();

    int getCurrentPage();

    void moveLeft();

    void moveRight();

    void moveFirst();

    void moveLast();

    void showAllNotes();

    void showPerformed();

    void showUnperformed();

    void sortDate();
}
