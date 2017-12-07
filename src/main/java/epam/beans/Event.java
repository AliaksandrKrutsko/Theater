package epam.beans;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {

    private String name;
    private double price;
    private Date date;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "name: " + this.name + ", " + " price: " + this.price;
    }

}
