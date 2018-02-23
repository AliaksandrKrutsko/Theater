package epam.dao;


import epam.dao.impl.EventDaoImpl;
import epam.dao.impl.UserDaoImpl;

public class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();
    private final EventDao event = new EventDaoImpl();
    private final UserDao user = new UserDaoImpl();

    public static DaoFactory getInstance() {
        return instance;
    }

    public EventDao getEventDao() {
        return event;
    }

    public UserDao getUserDao() {
        return user;
    }

}
