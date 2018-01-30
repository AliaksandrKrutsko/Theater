package epam.dao;

import epam.beans.Event;
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

    Map<Integer, Event> events = new HashMap<Integer, Event>() {{
        put(1, new Event("Event", 12, LocalDateTime.parse("08-08-12 11.00", dateTimeFormat)));
        put(2, new Event("Another event", 15, LocalDateTime.parse("08-08-12 10.00", dateTimeFormat)));
    }};


    public String enterEvent(Event event) {
        return null;
    }

    public String getEvent(String key) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        EventContainerDao eventContainerDao = (EventContainerDao) context.getBean("eventContainerDao");
        String value = eventContainerDao.eventBase.get(key);
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
        if (currentEvent==null) {
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
