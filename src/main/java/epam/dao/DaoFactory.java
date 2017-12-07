package epam.dao;


public class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();

    private final EventDao event = new EventContainerDao();

    public static DaoFactory getInstance() {
        return instance;
    }

    public EventDao getEventDao() {
        return event;
    }

}
