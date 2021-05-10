package lt.codeacademy.service;

import lt.codeacademy.HibernateConfig;
import lt.codeacademy.model.Note;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    public List<Note> getAll(String key, Object value) {
        return getAll(key, value, false);
    }

    public Note getById(Long id) {
        List<Note> notes = getAll("id", id, true);
        return notes.size() > 0 ? notes.get(0) : null;
    }

    public Note getByName(String name) {
        List<Note> notes = getAll("name", name, true);
        return notes.size() > 0 ? notes.get(0) : null;
    }

    // INSERT OR UPDATE
    public Note save(Note genre) {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(genre);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        return genre;
    }

    public void delete(Note genre) {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(genre);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

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

    private List<Note> getAll(String key, Object value, boolean limitOne) {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();
        List<Note> notes = new ArrayList<>();

        try {
            Query<Note> query = session.createQuery(String.format("FROM note WHERE %s = :%s", key, key), Note.class);
            query.setParameter(key, value);

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
