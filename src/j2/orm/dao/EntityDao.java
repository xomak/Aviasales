package j2.orm.dao;

import org.hibernate.HibernateException;

import java.util.List;

/**
 * @author Vladislav Vasilyev <vavlvl at mail.ru>
 */
public interface EntityDao<Type> {
    void     save(Type obj) throws HibernateException;
    void     update(Type obj) throws HibernateException;
    void     saveOrUpdate(Type obj) throws HibernateException;
    Type     getById(Number id) throws HibernateException;
    List<Type> getAll() throws HibernateException;
    void     delete(Type obj) throws HibernateException;
    Type     initializeAndUnproxy(Type obj) throws HibernateException;

}
