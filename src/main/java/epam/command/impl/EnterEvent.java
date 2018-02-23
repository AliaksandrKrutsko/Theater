package epam.command.impl;

import epam.actions.Action;
import epam.command.Command;
import epam.helper.ContextCreator;
import epam.service.EventService;
import epam.service.ServiceException;
import epam.service.ServiceFactory;

import java.util.logging.Logger;
import java.util.logging.Level;

public class EnterEvent implements Command {

    private static Logger log = Logger.getLogger(EnterEvent.class.getName());

    /**Message for trying to execute this command without moderator rights*/
    private static final String ERROR_MESSAGE = "You're not allowed to do this";

    private String response;

    public String execute(Action action) {

        if (action == ContextCreator.getApplicationContext().getBean("moderatorAction")) {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            EventService eventService = serviceFactory.getEventService();
            try {
                response = eventService.enterEvent(action.getEvent());
            } catch (ServiceException e) {
                log.log(Level.WARNING, e.getLocalizedMessage());
            }
            return response;
        }
        else return ERROR_MESSAGE;

    }

}
