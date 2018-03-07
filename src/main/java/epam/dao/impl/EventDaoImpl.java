package epam.dao.impl;

import epam.beans.Event;
import epam.beans.User;
import epam.dao.DaoException;
import epam.dao.EventDao;
import epam.helper.ContextCreator;
import epam.helper.EventMapper;
import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDateTime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;

import java.util.*;

public class EventDaoImpl implements EventDao {

    private JdbcTemplate jdbcTemplate = (JdbcTemplate) ContextCreator.getApplicationContext().getBean("jdbcTemplate");
    private static final String EVENT_TABLE = "event";

    /**
     * Method to execute command of entering new event into events collection
     *
     * @param event
     * @throws DaoException
     */
    public String enterEvent(Event event) throws DaoException {
        String response;
        String SQL = "insert into " + EVENT_TABLE + " (name, price, date) values (?, ?, ?)";
        this.jdbcTemplate.update(SQL, event.getName(), event.getPrice(), event.getDate().toString());
        response = "Event created: " + event.toString();
        return response;
    }

    /**
     * Method to execute command of getting a certain event by its key number
     *
     * @param key
     */
    public String getEvent(int key) throws DaoException {
        String SQL = "select * from " + EVENT_TABLE + " where id = ?";
        Event event = jdbcTemplate.queryForObject(SQL, new Object[]{key}, new EventMapper());
        return event.toString();
    }

    /**
     * Method to execute command of getting a certain event by its name
     *
     * @param eventName
     */
    @Override
    public List<Event> getEventByName(String eventName) {
        String SQL = "select * from " + EVENT_TABLE + " where name = ?";
        List<Event> events = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL, new Object[]{eventName});
        for (Map row : rows) {
            Event event = (Event) ContextCreator.getApplicationContext().getBean("event");
            event.setName((String) row.get("name"));
            event.setPrice((Integer) row.get("price"));
            event.setDate(LocalDateTime.parse((String) row.get("date")));
            events.add(event);
        }
        return events;
    }

    @Override
    public double getTicketsPrice(Event event, LocalDateTime dateTime, @Nullable User user) {
        double price = 0;
        return price;
    }

    /**
     * Method to get all the events and turn them to String
     */
    @Override
    public String getAllEvents() {
        String SQL = "select * from " + EVENT_TABLE;
        List<Event> events = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);
        for (Map row : rows) {
            Event event = (Event) ContextCreator.getApplicationContext().getBean("event");
            event.setName((String) row.get("name"));
            event.setPrice((Integer) row.get("price"));
            event.setDate(LocalDateTime.parse((String) row.get("date")));
            events.add(event);
        }
        return events.toString();
    }

    /**
     * Method to delete event by name
     *
     * @param eventName
     * @return
     */
    public String removeEventByName(String eventName) throws DaoException {
        String SQL = "delete from " + EVENT_TABLE + " where name = ?";
        jdbcTemplate.update(SQL, eventName);
        String response = eventName + " is deleted";
        return response;
    }

}
