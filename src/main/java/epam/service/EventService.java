package epam.service;

import epam.beans.Event;
import org.joda.time.LocalDate;

public interface EventService {

    String enterEvent(Event event) throws ServiceException;

    String getEvent(String key) throws ServiceException;

    String getEventByName(String eventName) throws ServiceException;

}
