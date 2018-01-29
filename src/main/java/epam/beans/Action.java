package epam.beans;

import epam.command.Command;
import epam.command.CommandType;

import java.io.Serializable;

public class Action implements Serializable {

    private Event event;
    private CommandType command;
    private String search;
    private int numberSearch;

    public Action() {

    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getNumberSearch() {
        return numberSearch;
    }

    public void setNumberSearch(int numberSearch) {
        this.numberSearch = numberSearch;
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

}
