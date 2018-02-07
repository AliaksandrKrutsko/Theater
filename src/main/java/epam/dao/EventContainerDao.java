package epam.dao;

import epam.beans.Event;
import epam.helper.ContextCreator;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.*;

public class EventContainerDao implements EventDao {

    String pattern = "yy-MM-dd hh.mm";
    Map<String, String> eventBase;
    DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern(pattern);
    private Event event;

    Map<Integer, Event> events = new HashMap<Integer, Event>() {{
        put(1, new Event("Event", 12, LocalDateTime.parse("08-08-12 11.00", dateTimeFormat)));
        put(2, new Event("Another event", 15, LocalDateTime.parse("08-08-12 10.00", dateTimeFormat)));
        put(3, new Event("Some movie", 20, LocalDateTime.parse("08-08-14 08.00", dateTimeFormat)));
    }};

    public String enterEvent(Event event) throws DaoException {
        Set<Integer> set = events.keySet();
        int key = 0;
        key = iterate(key, set);
        try {

            events.put(key, event);
        } catch (InputMismatchException e) {
            throw new DaoException("Something went wrong", e);
        }
        return events.get(key).toString();
    }

    private int iterate(int key, Set set) {
        int i;
        for (i = 1; i <= set.size(); i++) {
            if (i==set.size()) {
                break;
            }
        }
        key = i + 1;
        return key;
    }

    public String getEvent(String key) {
        EventContainerDao eventContainerDao = (EventContainerDao) ContextCreator.getApplicationContext().getBean("eventContainerDao");
        String value = eventContainerDao.eventBase.get(key);
        if (value==null) {
            value = "There is no such event";
        }
        return value;
    }

    @Override
    public String getEventByName(String eventName) {
        String currentEvent = null;
        for (Event event : events.values()) {
            if (event.getName().equals(eventName)) {
                currentEvent = event.toString();
            }
        }
        if (currentEvent == null) {
            currentEvent = "There is no such event";
        }
        return currentEvent;
    }

    @Override
    public String getAllEvents() {
        return events.toString();
    }

    public Map getEventBase() {
        System.out.println("Events: " + eventBase);
        return eventBase;
    }

    public void setEventBase(Map eventBase) {
        this.eventBase = eventBase;
    }

}
