package epam;

import epam.beans.Action;
import epam.command.Command;
import epam.command.CommandType;
import epam.dao.EventContainerDao;
import epam.helper.ContextCreator;
import epam.view.View;
import org.apache.commons.configuration.ConfigurationException;
import org.joda.time.LocalDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class App {


    private Map<CommandType, Command> commands;

    public App(Map<CommandType, Command> commands) {
        this.commands = commands;
    }

    public void executeThisCommand(CommandType type, Action action) {
        Command command = commands.get(type);
        command.execute(action);
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        View view = (View) context.getBean("view");
        Action action = view.enterCommand();
        app.executeThisCommand(action.getCommand(), action);
    }

}
