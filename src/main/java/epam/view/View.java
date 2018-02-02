package epam.view;

import epam.beans.Action;
import epam.beans.Event;
import epam.beans.ModeratorAction;
import epam.command.Command;
import epam.command.CommandType;
import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class View {

    public enum Status {

        MODERATOR("moderator"),
        USER("user");

        private String myStatus;

        Status (String status) {
            myStatus = status;
        }

        public String get() {
            return myStatus;
        }
    }

    private static InputStream in = View.class.getResourceAsStream("/event.properties");

    public Action enterCommand() throws IOException {

        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Action action = null;
        System.out.println("who are you?");
        String status = scanner.nextLine();
        if (status.equals(Status.MODERATOR.get())) {
            action = (Action) context.getBean("moderatorAction");
        } else if (status.equals(Status.USER.get())) {
            action = (Action) context.getBean("userAction");
        } else {
            System.out.println("System doesn't recognize you");
            System.exit(1);
        }
        Event event = (Event) context.getBean("event");

        System.out.println("please, enter command");
        String command = scanner.nextLine();
        action.setCommand(CommandType.valueOf(command.toUpperCase()));

        if (command.equals(CommandType.ENTER_EVENT.get())) {

            System.out.println("please, enter event name");
            event.setName(scanner.nextLine());
            System.out.println("please, enter event price");
            event.setPrice(scanner.nextInt());
            action.setEvent(event);
//            enterEvent(event.getName(), event.getPrice());

        } else if (command.equals(CommandType.GET_EVENT.get())) {

            System.out.println("please, enter the key");
            action.setSearch(scanner.nextLine());

        } else if (command.equals(CommandType.GET_EVENT_BY_NAME.get())) {

            System.out.println("please, enter event name");
            event.setName(scanner.nextLine());
            action.setEvent(event);

        } else if (command.equals(CommandType.GET_ALL_EVENTS.get())) {


        } else throw new IOException("No such command");

        return action;

    }

    private void enterEvent(String newName, int newPrice) throws IOException {
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
//        System.out.println(name + " " + price);
    }

    public void getDates(LocalDateTime startDate, LocalDateTime endDate) {
        int days = Days.daysBetween(startDate, endDate).getDays();
        List<LocalDateTime> dates = new ArrayList<>(days);
        for (int i = 0; i < days; i++) {
            LocalDateTime d = startDate.withFieldAdded(DurationFieldType.days(), i);
            dates.add(d);
        }
    }

}
