package ru.alvisid.notemanager.manager;

import ru.alvisid.notemanager.dao.NoteDao;

public class PageManagerImpl implements PageManager {
    private NoteDao noteDao;
    private int currentPage = 0;
    private String filter = "";
    private String sort = "";

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    @Override
    public void moveLeft() {
        if (currentPage > 0) {
            currentPage--;
        }
    }

    @Override
    public void moveRight() {
        if (currentPage < noteDao.getAmountPages(getQwery()) - 1) {
            currentPage++;
        }
    }

    @Override
    public void moveFirst() {
        currentPage = 0;
    }

    @Override
    public void moveLast() {
        currentPage = noteDao.getAmountPages(getQwery()) - 1;
    }

    @Override
    public void showAllNotes() {
        currentPage = 0;
        filter = "";
        sort = "";
    }

    @Override
    public void showPerformed() {
        currentPage = 0;
        filter = " where n.isPerformed = true";
    }

    @Override
    public void showUnperformed() {
        currentPage = 0;
        filter = " where n.isPerformed = false";
    }

    @Override
    public void sortDate() {
        if (sort.isEmpty() || sort.equals(" order by n.createDate DESC")){
            sort = " order by n.createDate ASC";
        } else if (sort.equals(" order by n.createDate ASC")) {
            sort = " order by n.createDate DESC";
        }
    }

    @Override
    public int getCurrentPage() {
        return currentPage;
    }

    @Override
    public String getQwery() {
        return filter + sort;
    }
}
