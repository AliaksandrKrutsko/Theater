package epam.command;

import epam.actions.Action;

public interface Command {

    String execute(Action action);

}
