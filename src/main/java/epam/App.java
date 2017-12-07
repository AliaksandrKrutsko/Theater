package epam;

import epam.beans.Action;
import epam.command.Command;
import epam.command.CommandType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {

    private Map<CommandType, Command> commands;

    public App(Map<CommandType, Command> commands) {
        this.commands = commands;
    }

    public void command(CommandType type, Action action) {
        Command command = commands.get(type);
        command.execute(action);
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        Action action = (Action) context.getBean("action");
        app.command(CommandType.ENTER_EVENT, action);

    }

}
