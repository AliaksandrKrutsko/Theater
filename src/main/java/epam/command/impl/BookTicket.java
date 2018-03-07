package epam.command.impl;

import epam.actions.Action;
import epam.beans.Event;
import epam.command.Command;
import epam.helper.ContextCreator;
import epam.service.BookingService;
import epam.service.EventService;
import epam.service.ServiceException;
import epam.service.ServiceFactory;
import org.joda.time.LocalDateTime;

import java.util.List;
import java.util.Scanner;

public class BookTicket implements Command {

    private String response;
    private List<Event> events;

    @Override
    public String execute(Action action) {

        String eventName = action.getEvent().getName();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        try {
            events = eventService.getEventByName(eventName);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        for (Event e: events) {
            System.out.println(e.getDate());
        }

        Event event = (Event) ContextCreator.getApplicationContext().getBean("event");
        Scanner scanner = new Scanner(System.in);
        System.out.println("please choose date from the above");
        String date = scanner.nextLine();
        event.setDate(LocalDateTime.parse(date));
        BookingService bookingService = serviceFactory.getBookingService();
        bookingService.bookTicket(event, action.getUser());
        scanner.close();

        return response;

    }

}
