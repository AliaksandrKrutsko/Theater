package epam.view;


import epam.beans.Action;
import epam.beans.Event;
import epam.command.CommandType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class View {

    private static InputStream in = View.class.getResourceAsStream("/event.properties");

    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    Action action = (Action) context.getBean("action");
    Event event = (Event) context.getBean("event");

    public CommandType enterCommand() throws IOException {

        CommandType commandType = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("please, enter command");
        action.setCommand(scanner.nextLine());
        String command = action.getCommand();

        if (command.equals(CommandType.ENTER_EVENT.get())) {
            System.out.println("please, enter event name");
            event.setName(scanner.nextLine());
            System.out.println("please, enter event price");
            event.setPrice(scanner.nextLine());
            enterEvent(event.getName(), event.getPrice());
            return commandType.ENTER_EVENT;

        } else throw new IOException("No such command");

    }

    private void enterEvent(String newName, String newPrice) throws IOException {

        Properties prop = new Properties();
        prop.load(in);
        String name = prop.getProperty("name");
        String price = prop.getProperty("price");
        in.close();
        FileOutputStream out = new FileOutputStream("/event.properties");
        prop.setProperty(name, newName);
        prop.setProperty(price, newPrice);
        prop.store(out, null);
        out.close();
        System.out.println(name + " " + price);

    }


}
