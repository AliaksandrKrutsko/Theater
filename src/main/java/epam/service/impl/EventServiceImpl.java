package epam.service.impl;

import com.sun.istack.internal.Nullable;
import epam.beans.Event;
import epam.dao.DaoException;
import epam.dao.DaoFactory;
import epam.dao.EventDao;
import epam.service.EventService;
import epam.service.ServiceException;
import org.joda.time.LocalDate;

public class EventServiceImpl implements EventService {

    @Override
    public String enterEvent(Event event) throws ServiceException {
        try {
            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            EventDao eventDao = daoObjectFactory.getEventDao();
            return eventDao.enterEvent(event);
        }
        catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public String getEvent(int key) throws ServiceException {
        try {
            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            EventDao eventDao = daoObjectFactory.getEventDao();
            return eventDao.getEvent(key);
        }
        catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public String getEventByName(String eventName) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        EventDao eventDao = daoObjectFactory.getEventDao();
        return eventDao.getEventByName(eventName);
    }

    @Override
    public String getAllEvents() throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        EventDao eventDao = daoFactory.getEventDao();
        return eventDao.getAllEvents();
    }

    @Override
    public String removeEventByName(String eventName) throws ServiceException {
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            EventDao eventDao = daoFactory.getEventDao();
            return eventDao.removeEventByName(eventName);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }


}
