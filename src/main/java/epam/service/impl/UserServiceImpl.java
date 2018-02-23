package epam.service.impl;

import epam.dao.DaoFactory;
import epam.dao.UserDao;
import epam.service.ServiceException;
import epam.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public String getUserByEmail(String userEmail) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        return userDao.getUserByEmail(userEmail);
    }

}
