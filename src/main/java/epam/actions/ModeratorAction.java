package epam.actions;

import epam.beans.Event;
import epam.command.CommandType;

import java.io.Serializable;

public class ModeratorAction implements Action {

    private Event event;
    private CommandType command;
    private String search;

    public ModeratorAction() {

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
        System.out.println("Action bean is initialized");
    }

}
