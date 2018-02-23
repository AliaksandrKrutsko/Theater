package epam.actions;

import epam.beans.Event;
import epam.beans.Ticket;
import epam.beans.User;
import epam.command.CommandType;

public interface Action<T> {

    T getSearch();

    void setSearch(T search);

    CommandType getCommand();

    void setCommand(CommandType command);

    Event getEvent();

    void setEvent(Event event);

    User getUser();

    void setUser(User user);

    Ticket getTicket();

    void setTicket(Ticket ticket);

}
