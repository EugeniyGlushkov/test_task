package ru.alvisid.notemanager.manager;

public interface PageManager {
    void moveLeft();

    void moveRight();

    void moveFirst();

    void moveLast();

    void showAllNotes();

    void showPerformed();

    void showUnperformed();

    void sortDate();

    int getCurrentPage();

    String getQwery();
}
