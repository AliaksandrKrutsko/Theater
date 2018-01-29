package epam.beans;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import java.io.Serializable;

public class Event implements Serializable, Comparable<Event> {

    private String name;
    private int price;
    private LocalDateTime date;

    public Event() {

    }

    public Event(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "name: " + this.name + ", " + " price: " + this.price + ", " + "date: " + this.date;
    }

    @Override
    public int compareTo(Event o) {
        if (this.getPrice() < o.getPrice()) return -1;
        if (this.getPrice() > o.getPrice()) return 1;
        return 0;
    }

}
