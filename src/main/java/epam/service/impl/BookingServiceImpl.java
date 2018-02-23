package epam.service.impl;

import epam.beans.Event;
import epam.beans.User;
import epam.dao.DaoFactory;
import epam.dao.EventDao;
import epam.service.BookingService;
import epam.service.ServiceException;
import org.joda.time.LocalDateTime;
import org.springframework.lang.Nullable;


public class BookingServiceImpl implements BookingService {

    @Override
    public double getTicketsPrice(Event event, LocalDateTime dateTime, @Nullable User user) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        EventDao eventDao = daoFactory.getEventDao();
        return eventDao.getTicketsPrice(event, dateTime, user);
    }

}
