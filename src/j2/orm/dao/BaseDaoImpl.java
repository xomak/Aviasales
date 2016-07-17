package j2.orm.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.proxy.HibernateProxy;
import j2.orm.HibernateUtil;

import java.util.List;

/**
 * @author Vladislav Vasilyev <vavlvl at mail.ru>
 */
public class BaseDaoImpl<Type> implements EntityDao<Type> {
    protected Class<Type> type;

    public BaseDaoImpl(Class<Type> type) {
        this.type = type;
    }

    @Override
    public void save(Type obj) throws HibernateException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Type obj) throws HibernateException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void saveOrUpdate(Type obj) throws HibernateException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(obj);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Type getById(Number id) throws HibernateException {
        Session session = null;
        Type obj = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            obj = session.load(type, id);
            Hibernate.initialize(obj);
            if (obj instanceof HibernateProxy) {
                obj = (Type) ((HibernateProxy) obj).getHibernateLazyInitializer().getImplementation();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return obj;
    }

    @Override
    public List<Type> getAll() throws HibernateException {
        Session session = null;
        List<Type> objs = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            objs = session.createCriteria(type)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return objs;
    }

    @Override
    public void delete(Type obj) throws HibernateException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Type initializeAndUnproxy(Type obj) throws HibernateException {
        if (obj instanceof HibernateProxy) {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.update(obj);
                Hibernate.initialize(obj);
                obj = (Type) ((HibernateProxy) obj).getHibernateLazyInitializer().getImplementation();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return obj;
    }

}
