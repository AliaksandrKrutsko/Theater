package epam.command;

public enum CommandType {

    ENTER_EVENT("enter_event"),
    GET_EVENT("get_event"),
    GET_EVENT_BY_NAME("get_event_by_name"),
    GET_ALL_EVENTS("get_all_events");

    private String myCommand;

    CommandType(String command) {
       myCommand = command;
    }

    public String get() {
        return myCommand;
    }
}
