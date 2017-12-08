package epam.beans;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {

    private String name;
    private String price;
    private Date date;

    public Event() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String toString() {
        return "name: " + this.name + ", " + " price: " + this.price;
    }

}
