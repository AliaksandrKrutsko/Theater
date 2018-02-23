package epam.command.impl;


import epam.actions.Action;
import epam.command.Command;
import epam.service.BookingService;
import epam.service.ServiceException;
import epam.service.ServiceFactory;

public class GetTicketsPrice implements Command {

    @Override
    public String execute(Action action) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookingService bookingService = serviceFactory.getBookingService();
        try {
            bookingService.getTicketsPrice(action.getEvent(), action.getEvent().getDate(), action.getUser());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;

    }
}
