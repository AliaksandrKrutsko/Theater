package epam.command;

import epam.actions.Action;
import epam.service.EventService;
import epam.service.ServiceException;
import epam.service.ServiceFactory;

public class GetEventByName implements Command {

    private String response;

    @Override
    public String execute(Action action) {

        String eventName = action.getEvent().getName();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        try {
            response = eventService.getEventByName(eventName);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        return response;
    }

}
