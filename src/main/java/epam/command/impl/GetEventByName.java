package epam.command.impl;

import epam.actions.Action;
import epam.command.Command;
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
            response = eventService.getEventByName(eventName).toString();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return response;
    }

}
