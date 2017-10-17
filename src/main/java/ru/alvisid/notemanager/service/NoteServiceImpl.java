package ru.alvisid.notemanager.service;

import org.springframework.stereotype.Service;
import ru.alvisid.notemanager.dao.NoteDao;
import ru.alvisid.notemanager.manager.PageManager;
import ru.alvisid.notemanager.model.Note;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private NoteDao noteDao;
    private PageManager pageManager;

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public void setPageManager(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    @Override
    @Transactional
    public void addNote(Note note) {
        noteDao.addNote(note);
    }

    @Override
    @Transactional
    public void updateNote(Note note) {
        noteDao.updateNote(note);
    }

    @Override
    @Transactional
    public void removeNote(int id) {
        noteDao.removeNote(id);
    }

    @Override
    @Transactional
    public Note getNoteById(int id) {
        return noteDao.getNoteById(id);
    }

    @Override
    @Transactional
    public List<Note> listNotes() {
        return noteDao.listNotes(pageManager.getCurrentPage(), pageManager.getQwery());
    }

    @Override
    @Transactional
    public int amountPages() {
        return noteDao.getAmountPages(pageManager.getQwery());
    }

    @Override
    @Transactional
    public int getCurrentPage() {
        return pageManager.getCurrentPage();
    }

    @Override
    @Transactional
    public void moveLeft() {
        pageManager.moveLeft();
    }

    @Override
    @Transactional
    public void moveRight() {
        pageManager.moveRight();
    }

    @Override
    @Transactional
    public void moveFirst() {
        pageManager.moveFirst();
    }

    @Override
    @Transactional
    public void moveLast() {
        pageManager.moveLast();
    }

    @Override
    @Transactional
    public void showAllNotes() {
        pageManager.showAllNotes();
    }

    @Override
    @Transactional
    public void showPerformed() {
        pageManager.showPerformed();
    }

    @Override
    @Transactional
    public void showUnperformed() {
        pageManager.showUnperformed();
    }

    @Override
    @Transactional
    public void sortDate() {
        pageManager.sortDate();
    }
}
