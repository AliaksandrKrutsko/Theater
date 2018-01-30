package epam.beans;

import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDateTime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Event implements Serializable, Comparable<Event> {

    private String name;
    private int price;
    private LocalDateTime date;
    private NavigableSet<LocalDateTime> airDates = new TreeSet<>();

    public Event() {

    }

    public Event(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Event(String name, int price, LocalDateTime date) {
        this.name = name;
        this.price = price;
        this.date = date;
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

    public void getDates(LocalDateTime startDate, LocalDateTime endDate) {
        int days = Days.daysBetween(startDate, endDate).getDays();
        for (int i=0; i < days; i++) {
            LocalDateTime d = startDate.withFieldAdded(DurationFieldType.days(), i);
            airDates.add(d);
        }
    }

}
