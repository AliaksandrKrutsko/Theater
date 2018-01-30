package epam.command;

import epam.beans.Action;
import epam.service.EventService;
import epam.service.ServiceException;
import epam.service.ServiceFactory;
import org.joda.time.LocalDate;

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
        System.out.println(response);
        return response;
    }

}
