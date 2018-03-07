package epam.helper;


import epam.beans.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Nullable
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = (User) ContextCreator.getApplicationContext().getBean("user");
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        return user;
    }
}
