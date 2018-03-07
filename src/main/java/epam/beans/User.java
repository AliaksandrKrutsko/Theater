package epam.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@PropertySource("login.properties")
public class User implements Serializable {

    private String name;
    @Value("#{${emails}}")
    private HashMap<String, String> emails;
    private String email;
    @Value("#{${user}}")
    private Map<String, String> userLoginData;
    private Ticket ticket;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getLoginData() {
        return userLoginData;
    }

    public HashMap<String, String> getEmails() {
        return emails;
    }

    public void setEmails(HashMap<String, String> emails) {
        this.emails = emails;
    }

    public Ticket getTicket() {
        return  ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "name: " + this.name + ", " + " email: " + this.email;
    }

}
