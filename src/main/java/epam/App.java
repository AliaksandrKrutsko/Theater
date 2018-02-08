package epam;

import epam.actions.Action;
import epam.command.Command;
import epam.command.CommandType;
import epam.view.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

public class App {


    private Map<CommandType, Command> commands;

    public App(Map<CommandType, Command> commands) {
        this.commands = commands;
    }

    public String executeCommand(CommandType type, Action action) {
        Command command = commands.get(type);
        return command.execute(action);
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        View view = (View) context.getBean("view");
        Action action = view.enterCommand();
        String response = app.executeCommand(action.getCommand(), action);
        System.out.println(response);
    }

}
