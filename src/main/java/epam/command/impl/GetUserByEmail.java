package epam.command.impl;

import epam.actions.Action;
import epam.command.Command;
import epam.helper.ContextCreator;
import epam.service.ServiceException;
import epam.service.ServiceFactory;
import epam.service.UserService;

public class GetUserByEmail implements Command {

    private String response;
    private static final String ERROR_MESSAGE = "You are now allowed to do this";

    @Override
    public String execute(Action action) {

        String userEmail = (String) action.getSearch();
        if (action == ContextCreator.getApplicationContext().getBean("moderatorAction")) {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            UserService userService = serviceFactory.getUserService();
            try {
                response = userService.getUserByEmail(userEmail);
            } catch (ServiceException e) {
                e.printStackTrace();
            }

            return response;
        } else return ERROR_MESSAGE;

    }

}
