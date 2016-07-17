package j2.orm;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Vladislav Vasilyev <vavlvl at mail.ru>
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            /*Properties prop= new Properties();
            prop.setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            prop.setProperty("hibernate.connection.url", "jdbc:sqlserver://localhost:1433;databaseName=AcademicLoad");
            prop.setProperty("hibernate.connection.username", "public_user");
            prop.setProperty("hibernate.connection.password", "123456");
            prop.setProperty("dialect", "org.hibernate.dialect.SQLServerDialect");*/
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
