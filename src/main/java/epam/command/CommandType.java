package epam.command;

public enum CommandType {

    ENTER_EVENT("enter_event"),
    GET_EVENT("get_event"),
    GET_EVENT_BY_NAME("get_event_by_name");

    private String myCommand;

    CommandType(String command) {
       myCommand = command;
    }

    public String get() {
        return myCommand;
    }
}
