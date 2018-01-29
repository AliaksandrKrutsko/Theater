package epam.service;

import com.sun.istack.internal.Nullable;
import epam.beans.Event;
import epam.dao.DaoFactory;
import epam.dao.EventDao;
import org.joda.time.LocalDate;

public class EventServiceImpl implements EventService {

    public String enterEvent(Event event) throws ServiceException {

        DaoFactory daoObjectFactory  = DaoFactory.getInstance();
        EventDao eventDao = daoObjectFactory.getEventDao();
        return eventDao.enterEvent(event);

    }

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

}
