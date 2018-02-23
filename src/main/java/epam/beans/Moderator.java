package epam.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

@Configuration
@PropertySource("login.properties")
public class Moderator {

    @Value("#{${moderator}}")
    Map<String, String> moderatorLoginData;

    public Map<String, String> getLoginData() {
        return moderatorLoginData;
    }

}
