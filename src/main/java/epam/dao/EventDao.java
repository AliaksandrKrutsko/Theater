package epam.dao;

import epam.beans.Event;
import epam.beans.User;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.lang.Nullable;

public interface EventDao {

    /**
     * Method to execute command of entering new event into events collection
     * @param event
     * @throws DaoException
     */
    String enterEvent(Event event) throws DaoException;

    /**
     * Method to execute command of getting a certain event by its key number
     * @param key
     * @throws DaoException
     */
    String getEvent(int key) throws DaoException;

    /**
     * Method to execute command of getting a certain event by its name
     * @param eventName
     */
    String getEventByName(String eventName);

    /**
     * Method to get all the events and turn them to String
     */
    String getAllEvents();

    double getTicketsPrice(Event event, LocalDateTime dateTime, @Nullable User user);

    String removeEventByName(String eventName) throws DaoException;

}
