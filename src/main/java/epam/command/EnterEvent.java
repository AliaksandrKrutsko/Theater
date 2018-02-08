package epam.command;

import epam.actions.Action;
import epam.helper.ContextCreator;
import epam.service.EventService;
import epam.service.ServiceException;
import epam.service.ServiceFactory;

import java.util.logging.Logger;
import java.util.logging.Level;

public class EnterEvent implements Command {

    private static Logger log = Logger.getLogger(EnterEvent.class.getName());
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
