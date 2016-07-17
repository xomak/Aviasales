package j2.orm.dao;


/**
 * @author Vladislav Vasilyev <vavlvl at mail.ru>
 */
public class Factory {

    public static<T> EntityDao<T> getDao(Class<T> type) {
        return new BaseDaoImpl<T>(type);
    }
}
