package epam.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

@Configuration
@PropertySource("login.properties")
public class User {

    private String name;
    private String email;
    @Value("#{${user}}")
    private Map<String, String> userLoginData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

    public Map<String, String> getLoginData() {
        return userLoginData;
    }

}
