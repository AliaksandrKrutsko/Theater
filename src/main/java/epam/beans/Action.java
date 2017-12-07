package epam.beans;

import java.io.Serializable;

public class Action implements Serializable {

    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }


}
