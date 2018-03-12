package epam.view;

import epam.actions.Action;
import epam.beans.Event;
import epam.beans.Moderator;
import epam.beans.User;
import epam.command.CommandType;
import epam.helper.ContextCreator;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Configuration
@PropertySource("login.properties")
public class View {

    private Moderator moderator;
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

    /**
     * Method to login and enter command
     *
     * @throws IOException
     */
    public Action enterCommand() throws IOException {

        Scanner scanner = new Scanner(System.in);
        action = null;
        System.out.println("who are you?");
        String status = scanner.nextLine();
        if (status.equals(Status.MODERATOR.get())) {
            moderator = (Moderator) ContextCreator.getApplicationContext().getBean("moderator");
            System.out.println("please, enter login");
            String login = scanner.nextLine();
            System.out.println("please, enter password");
            String password = scanner.nextLine();
            if (moderator.getLoginData().get(login).equals(password)) {
                action = (Action) ContextCreator.getApplicationContext().getBean("moderatorAction");
            } else {
                System.out.println("Ensure that your email address and password are correct");
                System.exit(1);
            }

        } else if (status.equals(Status.USER.get())) {
            user = (User) ContextCreator.getApplicationContext().getBean("user");
            System.out.println("please, enter login");
            String login = scanner.nextLine();
            System.out.println("please, enter password");
            String password = scanner.nextLine();
            if (user.getLoginData().get(login).equals(password)) {
                action = (Action) ContextCreator.getApplicationContext().getBean("userAction");
                user.setName(login);
                action.setUser(user);
            } else {
                System.out.println("Ensure that your email address and password are correct");
                System.exit(1);
            }

        } else {
            System.out.println("System doesn't recognize you");
            System.exit(1);
        }
        event = (Event) ContextCreator.getApplicationContext().getBean("event");
        System.out.println("please, enter command");
        String command = scanner.nextLine();
        action.setCommand(CommandType.valueOf(command.toUpperCase()));

        if (command.equalsIgnoreCase(CommandType.ENTER_EVENT.get())) {

            enterEvent();

        } else if (command.equalsIgnoreCase(CommandType.GET_EVENT.get())) {

            getEvent();

        } else if (command.equalsIgnoreCase(CommandType.GET_EVENT_BY_NAME.get())) {

            getEventByName();

        } else if (command.equalsIgnoreCase(CommandType.GET_ALL_EVENTS.get())) {

        } else if (command.equalsIgnoreCase(CommandType.GET_USER_BY_EMAIL.get())) {

            getUserByEmail();

        } else if (command.equalsIgnoreCase(CommandType.GET_TICKETS_PRICE.get())) {

        } else if (command.equalsIgnoreCase(CommandType.REMOVE_EVENT_BY_NAME.get())) {

            removeEventByName();

        } else if (command.equalsIgnoreCase(CommandType.BOOK_TICKET.get())) {

            getEventByName();

        } else throw new IOException("No such command");

//        if (scanner != null)
//            scanner.close();

        return action;

    }

    /**
     * "Get event by name" command
     */
    private void getEventByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please, enter event name");
        event.setName(scanner.nextLine());
        action.setEvent(event);
//        scanner.close();
    }

    /**
     * "Enter event" command
     */
    private void enterEvent() {
        int year = DateTime.now().getYear();
        int day;
        int month;
        double time;
        String pattern = "yy-MM-dd HH.mm";
        DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern(pattern);
        Scanner scanner = new Scanner(System.in);
        System.out.println("please, enter event name");
        event.setName(scanner.nextLine());
        System.out.println("please, enter event price");
        event.setPrice(scanner.nextInt());
        System.out.println("please, enter month");
        month = scanner.nextInt();
        System.out.println("please, enter day");
        day = scanner.nextInt();
        System.out.println("please, enter time");
        time = scanner.nextDouble();
        event.setDate(LocalDateTime.parse(year + "-" + month + "-" + day + " " + time, dateTimeFormat));
        action.setEvent(event);
        scanner.close();
    }

    /**
     * "Get event" command
     */
    private void getEvent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please, enter the key");
        action.setSearch(scanner.nextLine());
        scanner.close();
    }

    /**
     * "Get user by email" command
     */
    private void getUserByEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please, enter the email");
        action.setSearch(scanner.nextLine());
        scanner.close();
    }

    /**
     * "Remove event by name" command
     */
    private void removeEventByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please, enter event name");
        event.setName(scanner.nextLine());
        action.setEvent(event);
        scanner.close();
    }

    /**
     * Method to rewrite property values of a given event
     *
     * @param newName
     * @param newPrice
     * @throws IOException
     */
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
