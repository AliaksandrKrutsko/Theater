package epam.beans;

import org.joda.time.LocalDateTime;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Objects;

public class Ticket implements Serializable, Comparable<Ticket> {

    private User user;
    private Event event;
    private LocalDateTime dateTime;
    private int seat;
    private boolean isTaken;

    public Ticket(User user, Event event, LocalDateTime dateTime, int seat, boolean isTaken) {
        this.user = user;
        this.event = event;
        this.dateTime = dateTime;
        this.seat = seat;
        this.isTaken = isTaken;
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, event, dateTime, seat);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Ticket other = (Ticket) obj;
        if (dateTime == null) {
            if (other.dateTime != null) {
                return false;
            }
        } else if (!dateTime.equals(other.dateTime)) {
            return false;
        }
        if (event == null) {
            if (other.event != null) {
                return false;
            }
        } else if (!event.equals(other.event)) {
            return false;
        }
        if (seat != other.seat) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Ticket other) {
        if (other == null) {
            return 1;
        }
        int result = dateTime.compareTo(other.getDateTime());

        if (result == 0) {
            result = event.getName().compareTo(other.getEvent().getName());
        }
        if (result == 0) {
            result = Long.compare(seat, other.getSeat());
        }
        return result;
    }
}
