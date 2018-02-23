package epam.service;

import epam.beans.Event;
import org.joda.time.LocalDate;

public interface EventService {

    String enterEvent(Event event) throws ServiceException;

    String getEvent(int key) throws ServiceException;

    String getEventByName(String eventName) throws ServiceException;

    String getAllEvents() throws ServiceException;

    String removeEventByName(String eventName) throws ServiceException;

}
