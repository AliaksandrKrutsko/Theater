package epam.dao.impl;

import epam.beans.User;
import epam.dao.UserDao;
import epam.helper.ContextCreator;

public class UserDaoImpl implements UserDao {

    private User user;

    /**
     * Method to get a certain user by his/her email
     * @return
     */
    @Override
    public String getUserByEmail(String userEmail) {
        user = (User) ContextCreator.getApplicationContext().getBean("user");
        String response = user.getEmails().get(userEmail);
        return response;
    }

}
