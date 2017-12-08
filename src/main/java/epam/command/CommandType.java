package epam.command;

public enum CommandType {

    ENTER_EVENT("enter_event");

    private String myCommand;

    CommandType(String command) {
       myCommand = command;
    }

    public String get() {
        return myCommand;
    }
}
