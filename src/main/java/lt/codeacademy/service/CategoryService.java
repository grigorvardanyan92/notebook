package lt.codeacademy.service;

import lt.codeacademy.model.Category;
import lt.codeacademy.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    public List<Category> getAll(String key, Object value) {
        return getAll(key, value, false);
    }

    public Category getById(Integer id) {
        List<Category> categories = getAll("id", id, true);
        return categories.size() > 0 ? categories.get(0) : null;
    }

    public Category getByName(String name) {
        List<Category> categories = getAll("name", name, true);
        return categories.size() > 0 ? categories.get(0) : null;
    }

    // INSERT OR UPDATE
    public Category save(Category genre) {
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

    public void delete(Category genre) {
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

    public List<Category> getAll() {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();
        List<Category> categories = new ArrayList<>();

        try {
            Query<Category> query = session.createQuery("FROM note", Category.class);
            categories = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        return categories;
    }

    private List<Category> getAll(String key, Object value, boolean limitOne) {
        Session session = HibernateConfig.openSession();
        Transaction transaction = session.beginTransaction();
        List<Category> categories = new ArrayList<>();

        try {
            Query<Category> query = session.createQuery(
                    String.format("FROM Category WHERE %s = :%s", key, key), Category.class
            );
            query.setParameter(key, value);

            if (limitOne) {
                query.setMaxResults(1);
            }

            categories = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        return categories;
    }
}
