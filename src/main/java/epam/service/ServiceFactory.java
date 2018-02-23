package epam.service;

import epam.service.impl.BookingServiceImpl;
import epam.service.impl.EventServiceImpl;
import epam.service.impl.UserServiceImpl;

public class ServiceFactory {

    private static ServiceFactory instance = null;
    private final EventService eventService = new EventServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final BookingService bookingService = new BookingServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    public EventService getEventService() {
        return eventService;
    }

    public UserService getUserService() {
        return userService;
    }

    public BookingService getBookingService() {
        return bookingService;
    }

}
