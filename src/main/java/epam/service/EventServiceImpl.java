package epam.service;

import com.sun.istack.internal.Nullable;
import epam.beans.Event;
import epam.dao.DaoException;
import epam.dao.DaoFactory;
import epam.dao.EventDao;
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
    public String getEvent(String key) throws ServiceException {
        DaoFactory daoObjectFactory  = DaoFactory.getInstance();
        EventDao eventDao = daoObjectFactory.getEventDao();
        return eventDao.getEvent(key);
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

}
