package epam.service;

import epam.beans.Event;
import epam.dao.DaoFactory;
import epam.dao.EventDao;

public class EventServiceImpl implements EventService {

    @Override
    public String enterEvent(Event event) throws ServiceException {

        DaoFactory daoObjectFactory  = DaoFactory.getInstance();
        EventDao eventDao = daoObjectFactory.getEventDao();
        return eventDao.enterEvent(event);

    }
}
