package epam.command;

import epam.beans.Action;
import epam.beans.Event;
import epam.service.EventService;
import epam.service.ServiceException;
import epam.service.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EnterEvent implements Command {

    private String response;

    @Autowired
    Event event;

    @Override
    public String execute(Action action) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        try {
           response = eventService.enterEvent(action.getEvent());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        System.out.println(response);

        return response;
    }

}
