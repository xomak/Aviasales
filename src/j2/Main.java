package j2;

import j2.orm.HibernateUtil;
import j2.orm.dao.Factory;
import j2.orm.entities.*;

public class Main {

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();

        Factory.getDao(EAirline.class).getAll();
        Factory.getDao(EAirport.class).getAll();
        Factory.getDao(EClient.class).getAll();
        Factory.getDao(EContry.class).getAll();
        Factory.getDao(EFlight.class).getAll();
        Factory.getDao(EFlightClass.class).getAll();
        Factory.getDao(EFlightCost.class).getAll();
        Factory.getDao(EFlightCostId.class).getAll();
        Factory.getDao(EFlightInfo.class).getAll();
        Factory.getDao(ERole.class).getAll();
        Factory.getDao(ETicket.class).getAll();
        Factory.getDao(ETIcketId.class).getAll();
        Factory.getDao(EUser.class).getAll();

        HibernateUtil.closeSessionFactory();
    }
}
