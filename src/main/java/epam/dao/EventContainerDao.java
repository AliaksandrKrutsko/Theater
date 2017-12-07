package epam.dao;

import epam.beans.Event;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class EventContainerDao implements EventDao {

    private String ok = "Everything ok";
    private String oops = "Something wrong";
    Map<Integer, Event> eventBase = new HashMap<Integer, Event>();



    public String enterEvent(Event event) {
        int max = 0;
        Set<Integer> set = eventBase.keySet();
        if (set.isEmpty()) {
            max = 1;
        } else
            for (int d : set) {
            if (d > max)
                max = d;
            }
        eventBase.put(max, event);
        Event value = eventBase.get(max);
        return value.toString();
    }

}
