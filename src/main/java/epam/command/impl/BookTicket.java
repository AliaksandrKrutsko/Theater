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
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Scanner;

public class BookTicket implements Command {

    private String response;
    private List<Event> events;
    Event event = (Event) ContextCreator.getApplicationContext().getBean("event");
    String pattern = "yy-MM-dd HH.mm";
    DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern(pattern);

    @Override
    public String execute(Action action) {

        Scanner scanner = new Scanner(System.in);
        String eventName = action.getEvent().getName();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        try {
            events = eventService.getEventByName(eventName);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        for (Event e : events) {
            System.out.println(e.getDate());
        }

        System.out.println("please choose date from above");
        String date = scanner.nextLine();
        scanner.close();
        event.setDate(LocalDateTime.parse(date, dateTimeFormat));
        event.setName(eventName);
        BookingService bookingService = serviceFactory.getBookingService();
        response = bookingService.bookTicket(event, action.getUser()).toString();

        return response;

    }

}
