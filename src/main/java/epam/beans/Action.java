package epam.beans;

import epam.command.Command;

import java.io.Serializable;

public class Action implements Serializable {

    private Event event;
    private String command;

    public Action() {

    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }


}
