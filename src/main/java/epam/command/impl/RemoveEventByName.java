package epam.command.impl;


import epam.actions.Action;
import epam.command.Command;
import epam.helper.ContextCreator;
import epam.service.EventService;
import epam.service.ServiceException;
import epam.service.ServiceFactory;

public class RemoveEventByName implements Command {

    String response;

    /**Message for trying to execute this command without moderator rights*/
    private static final String ERROR_MESSAGE = "You're not allowed to do this";

    @Override
    public String execute(Action action) {

        String eventName = action.getEvent().getName();
        if (action == ContextCreator.getApplicationContext().getBean("moderatorAction")) {
            try {
                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                EventService eventService = serviceFactory.getEventService();
                response = eventService.removeEventByName(eventName);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        } else response = ERROR_MESSAGE;

        return response;
    }
}
