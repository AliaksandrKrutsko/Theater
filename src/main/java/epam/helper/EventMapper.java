package epam.helper;

import epam.beans.Event;
import org.joda.time.LocalDateTime;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EventMapper implements RowMapper<Event> {

    @Nullable
    @Override
    public Event mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Event event = (Event) ContextCreator.getApplicationContext().getBean("event");
        event.setName(resultSet.getString("name"));
        event.setPrice(resultSet.getInt("price"));
        event.setDate(LocalDateTime.parse(resultSet.getString("date")));
        return event;
    }
}
