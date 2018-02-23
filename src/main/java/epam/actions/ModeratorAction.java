package epam.actions;

import epam.beans.Event;
import epam.beans.Ticket;
import epam.beans.User;
import epam.command.CommandType;

public class ModeratorAction<T extends Object> implements Action {

    private Event event;
    private CommandType command;
    private T search;
    private User user;
    private Ticket ticket;

    public T getSearch() {
        return search;
    }

    @Override
    public void setSearch(Object search) {
        this.search = (T) search;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Ticket getTicket() {
        return ticket;
    }

    @Override
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void init() {
        System.out.println("You have logged in as a moderator");
    }

}
