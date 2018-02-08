package epam.view;

import epam.actions.Action;
import epam.beans.Event;
import epam.beans.User;
import epam.command.CommandType;
import epam.helper.ContextCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.*;
import java.util.*;

@Configuration
@PropertySource("login.properties")
public class View {

    @Value("#{${moderator}}")
    Map<String, String> moderatorLogin;

    private User user;
    private Event event;
    private Action action;

    public enum Status {

        MODERATOR("moderator"),
        USER("user");

        private String myStatus;

        Status(String status) {
            myStatus = status;
        }

        public String get() {
            return myStatus;
        }
    }

    private static InputStream in = View.class.getResourceAsStream("/event.properties");

    public Action enterCommand() throws IOException {

        Scanner scanner = new Scanner(System.in);
        action = null;
        System.out.println("who are you?");
        String status = scanner.nextLine();
        if (status.equals(Status.MODERATOR.get())) {

            action = loginAsModerator();

        } else if (status.equals(Status.USER.get())) {

            action = loginAsUser();

        } else {
            System.out.println("System doesn't recognize you");
            System.exit(1);
        }
        event = (Event) ContextCreator.getApplicationContext().getBean("event");
        System.out.println("please, enter command");
        String command = scanner.nextLine();
        action.setCommand(CommandType.valueOf(command.toUpperCase()));

        if (command.equals(CommandType.ENTER_EVENT.get())) {

            enterEvent();

        } else if (command.equals(CommandType.GET_EVENT.get())) {

            getEvent();

        } else if (command.equals(CommandType.GET_EVENT_BY_NAME.get())) {

            getEventByName();

        } else if (command.equals(CommandType.GET_ALL_EVENTS.get())) {


        } else throw new IOException("No such command");

        if (scanner != null)
            scanner.close();

        return action;

    }

    private void getEventByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please, enter event name");
        event.setName(scanner.nextLine());
        action.setEvent(event);
        scanner.close();
    }

    private void enterEvent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please, enter event name");
        event.setName(scanner.nextLine());
        System.out.println("please, enter event price");
        event.setPrice(scanner.nextInt());
        action.setEvent(event);
//        enterEventInProperties(event.getName(), event.getPrice());
        scanner.close();
    }

    private void getEvent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please, enter the key");
        action.setSearch(scanner.nextLine());
        scanner.close();
    }

    private Action loginAsModerator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please, enter login");
        String login = scanner.nextLine();
        System.out.println("please, enter password");
        String password = scanner.nextLine();
        scanner.close();
        if (moderatorLogin.get(login).equals(password)) {
            return action = (Action) ContextCreator.getApplicationContext().getBean("moderatorAction");
        } else
            System.out.println("Ensure that your email address and password are correct");
            System.exit(1);
            return null;
    }

    private Action loginAsUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please, enter login");
        String login = scanner.nextLine();
        System.out.println("please, enter password");
        String password = scanner.nextLine();
        scanner.close();
        if (user.getLoginData().get(login).equals(password)) {
            return action = (Action) ContextCreator.getApplicationContext().getBean("userAction");
        } else
            System.out.println("Ensure that your email address and password are correct");
            System.exit(1);
            return null;
    }

    private void enterEventInProperties(String newName, int newPrice) throws IOException {
        Properties prop = new Properties();
        prop.load(in);
        String name = prop.getProperty("name");
        String price = prop.getProperty("price");
        in.close();
        FileOutputStream out = new FileOutputStream("/event.properties");
        prop.setProperty(name, newName);
        prop.setProperty(price, String.valueOf(newPrice));
        prop.store(out, null);
        out.close();
    }

}
