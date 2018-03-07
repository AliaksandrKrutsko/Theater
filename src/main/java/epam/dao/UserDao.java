package epam.dao;

import epam.beans.Event;
import epam.beans.Ticket;
import epam.beans.User;

public interface UserDao {

    /**
     * Method to get a certain user by his/her email
     * @return
     */
    String getUserByEmail(String userEmail);

    Ticket bookTicket(Event event, User user);


}
