package epam.dao;

import epam.beans.Event;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.*;

public class EventContainerDao implements EventDao {

    Map<String, String> eventBase;

    Map<Integer, Event> events = new HashMap<Integer, Event>() {{
        put(1, new Event("SomeName", 12));
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
        return currentEvent;
    }

    public Map getEventBase() {
        System.out.println("Events: " + eventBase);
        return eventBase;
    }

    public void setEventBase(Map eventBase) {
        this.eventBase = eventBase;
    }

}
