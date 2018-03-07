package epam.beans;

import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;
import java.util.NavigableSet;
import java.util.TreeSet;

@Configuration
@PropertySource("event.properties")
public class Event implements Serializable, Comparable<Event> {

    private String name;
    private int price;
    private LocalDateTime date;
//    @Value("#{${date}}")
    private NavigableSet<String> airDates = new TreeSet<>();

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

    public NavigableSet<String> getAirDates() {
        return airDates;
    }

    public void setAirDates(NavigableSet<String> airDates) {
        this.airDates = airDates;
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

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + price;
        result = 31 * result + date.hashCode();
        return result;
    }

}
