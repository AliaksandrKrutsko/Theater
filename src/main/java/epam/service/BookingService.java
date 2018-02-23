package epam.service;

import epam.beans.Event;
import epam.beans.User;
import org.joda.time.LocalDateTime;
import org.springframework.lang.Nullable;

import java.util.Set;

public interface BookingService {

    public double getTicketsPrice(Event event, LocalDateTime dateTime, @Nullable User user) throws ServiceException;

}
