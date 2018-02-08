package epam.command;

import epam.actions.Action;
import epam.service.EventService;
import epam.service.ServiceException;
import epam.service.ServiceFactory;

public class GetEvent implements Command {

    private String response;

    public String execute(Action action) {

        String key = action.getSearch();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        try {
            response = eventService.getEvent(key);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return response;
    }

}
