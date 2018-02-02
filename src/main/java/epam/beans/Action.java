package epam.beans;

import epam.command.CommandType;

public interface Action {

    String getSearch();

    void setSearch(String search);

    CommandType getCommand();

    void setCommand(CommandType command);

    Event getEvent();

    void setEvent(Event event);

}
