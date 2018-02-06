package epam.command;

import epam.actions.Action;
import epam.service.EventService;
import epam.service.ServiceException;
import epam.service.ServiceFactory;

public class EnterEvent implements Command {

    private String response;

    public String execute(Action action) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        try {
           response = eventService.enterEvent(action.getEvent());
        } catch (ServiceException e) {
            e.getLocalizedMessage();
        }
        System.out.println(response + " was added");
        return response;

    }

}
