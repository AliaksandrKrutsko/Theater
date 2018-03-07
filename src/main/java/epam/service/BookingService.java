package epam.service;

import epam.beans.Event;
import epam.beans.Ticket;
import epam.beans.User;
import org.joda.time.LocalDateTime;
import org.springframework.lang.Nullable;

import java.util.Set;

public interface BookingService {

    double getTicketsPrice(Event event, LocalDateTime dateTime, @Nullable User user) throws ServiceException;

    Ticket bookTicket(Event event, User user);

}
