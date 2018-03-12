package epam.dao.impl;

import epam.beans.Event;
import epam.beans.Ticket;
import epam.beans.User;
import epam.dao.DaoException;
import epam.dao.UserDao;
import epam.helper.ContextCreator;
import epam.helper.EventMapper;
import epam.helper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate = (JdbcTemplate) ContextCreator.getApplicationContext().getBean("jdbcTemplate");
    private static final String USER_TABLE = "user";
    private static final String EVENT_TABLE = "event";
    private static final String TICKET_TABLE = "ticket";

    private User user = (User) ContextCreator.getApplicationContext().getBean("user");

    /**
     * Method to get a certain user by his/her email
     *
     * @return
     */
    @Override
    public String getUserByEmail(String userEmail) {
        String SQL = "SELECT * FROM " + USER_TABLE + " WHERE email = ?";
        user = jdbcTemplate.queryForObject(SQL, new Object[]{userEmail}, new UserMapper());
        return user.toString();
    }

    /**
     * Method to enter information about booked ticket into database
     * @param event
     * @param user
     * @return
     */
    public Ticket bookTicket(Event event, User user) {
        String SQL_EVENT = "SELECT * FROM " + EVENT_TABLE + " WHERE name = ?";
        event = jdbcTemplate.queryForObject(SQL_EVENT, new Object[] {event.getName()}, new EventMapper());
        String SQL = "INSERT INTO" + TICKET_TABLE + " (eventname, price, user, seat, istaken) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQL, event.getName(), event.getPrice(), user.getName(), 1, true);
        Ticket ticket = new Ticket(user, event, event.getDate(), 1, true);
        return ticket;
    }

}
