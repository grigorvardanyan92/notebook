package lt.codeacademy.service;

import lt.codeacademy.HibernateConfig;
import lt.codeacademy.model.Note;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class NoteService {

    public Note getById(Integer id) {
        List<Note> notes = getAll("id", id, true);
        return notes.size() > 0 ? notes.get(0) : null;
    }

    // INSERT OR UPDATE
    public Note save(Note note) {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(note);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        return note;
    }

    public void delete(Note note) {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(note);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    // HQL example
    public List<Note> getAll() {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();
        List<Note> notes = new ArrayList<>();

        try {
            Query<Note> query = session.createQuery("FROM note", Note.class);
            notes = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        return notes;
    }

    // HQL example
    private List<Note> getAll(String col, Object val, boolean limitOne) {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();
        List<Note> notes = new ArrayList<>();

        try {
            Query<Note> query = session.createQuery(String.format(
                    "FROM Note WHERE %s = :%s", col, col), Note.class
            );
            query.setParameter(col, val);

            if (limitOne) {
                query.setMaxResults(1);
            }

            notes = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        return notes;
    }
}
