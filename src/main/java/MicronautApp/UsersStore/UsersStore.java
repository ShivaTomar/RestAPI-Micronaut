package MicronautApp.UsersStore;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.convert.format.MapFormat;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class UsersStore {

    private Map<String, String> users = new HashMap<>();
    private Map<String, String> roles = new HashMap<>();
    private Map<String, UsersAttributes> attributes = new HashMap<>();

    public UsersStore() {
        users.put("smith", "smith123");
        users.put("john", "john123");
        users.put("cory", "cory123");

        roles.put("smith", "ADMIN");
        roles.put("john", "VIEWER");
        roles.put("cory", "VIEWER");

        attributes.put("smith", new UsersAttributes(24, "8527587639", "Doctor"));
        attributes.put("john", new UsersAttributes(18, "9718072365", "Student"));
        attributes.put("cory", new UsersAttributes(32, "7011569854", "Draft Man"));
    }

    public String getUserPassword(String username) {
        return users.get(username);
    }

    public String getUserRole(String username) {
        return roles.get(username);
    }

    public Map<String, Object> getUserAttr(String username) {
       Map<String ,Object> attr = new HashMap<>();
       attr.put(username, attributes.get(username));
       return attr;
    }
}
