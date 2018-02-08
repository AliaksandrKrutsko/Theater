package epam.service;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final EventService eventService = new EventServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public EventService getEventService() {
        return eventService;
    }

}
