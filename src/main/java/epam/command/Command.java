package epam.command;

import epam.beans.Action;

public interface Command {


    String execute(Action action);

}
