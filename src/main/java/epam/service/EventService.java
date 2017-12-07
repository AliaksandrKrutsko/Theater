package epam.service;

import epam.beans.Event;

public interface EventService {

    public String enterEvent(Event event) throws ServiceException;

}
