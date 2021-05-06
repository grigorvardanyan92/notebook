package lt.codeacademy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    private static final Configuration config = new Configuration().configure();

    public static Session getSession() {
        return config.buildSessionFactory().openSession();
    }
}
