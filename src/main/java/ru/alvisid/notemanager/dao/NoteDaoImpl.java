package ru.alvisid.notemanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.alvisid.notemanager.model.Note;

import java.util.List;

@Repository
public class NoteDaoImpl implements NoteDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addNote(Note note) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(note);
    }

    @Override
    public void updateNote(Note note) {
        Session session = sessionFactory.getCurrentSession();
        session.update(note);
    }

    @Override
    public void removeNote(int id) {
        Session session = sessionFactory.getCurrentSession();
        Note currentNote = (Note) session.get(Note.class, new Integer(id));

        if (currentNote != null){
            session.delete(currentNote);
        }
    }

    @Override
    public Note getNoteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Note note =  (Note) session.get(Note.class, new Integer(id));
        return note;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Note> listNotes(int pageNum, String qwery) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(String.format("from Note n%s", qwery));
        query.setFirstResult(pageNum * 10);
        query.setMaxResults(10);
        List<Note> noteList = query.list();
        return noteList;
    }

    /*
    *returnes amount pages per 10 notes
     */
    @Override
    public int getAmountPages(String qwery) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(String.format("select count (id) from Note n%s", qwery));
        int amount = ((Long)query.uniqueResult()).intValue();

        return (amount - 1) / 10 + 1;
    }
}
