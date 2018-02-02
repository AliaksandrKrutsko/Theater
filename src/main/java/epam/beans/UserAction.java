package epam.beans;

import epam.command.CommandType;

import java.io.Serializable;

public class UserAction implements Serializable, Action {

    private Event event;
    private CommandType command;
    private String search;

    public UserAction() {

    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public CommandType getCommand() {
        return command;
    }

    public void setCommand(CommandType command) {
        this.command = command;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void init() {

    }

}
