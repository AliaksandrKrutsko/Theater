package epam.command;

import epam.actions.Action;
import epam.service.EventService;
import epam.service.ServiceException;
import epam.service.ServiceFactory;

public class GetAllEvents implements Command {

    private String response;


    @Override
    public String execute(Action action) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        try {
            response = eventService.getAllEvents();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        return response;
    }


}
