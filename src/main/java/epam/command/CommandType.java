package epam.command;

public enum CommandType {

    ENTER_EVENT("enter_event"),
    GET_EVENT("get_event"),
    GET_EVENT_BY_NAME("get_event_by_name"),
    GET_ALL_EVENTS("get_all_events"),
    GET_USER_BY_EMAIL("get_user_by_email"),
    GET_TICKETS_PRICE("get_tickets_price"),
    REMOVE_EVENT_BY_NAME("remove_event_by_name"),
    BOOK_TICKET("book_ticket");

    private String myCommand;

    CommandType(String command) {
       myCommand = command;
    }

    public String get() {
        return myCommand;
    }
}
