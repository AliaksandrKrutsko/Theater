package epam.dao;

import epam.beans.Event;
import org.joda.time.LocalDate;

public interface EventDao {

    String enterEvent(Event event) throws DaoException;

    String getEvent(String key);

    String getEventByName(String eventName);

    String getAllEvents();

}
