package contact.list.project.api.dtos.requests;

import lombok.Getter;

import java.util.Map;

@Getter
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserRequest() {
    }

    public UserRequest(Map<String, String> user) {
        this.firstName = user.get("firstName");
        this.lastName = user.get("lastName");
        this.email = user.get("email");
        this.password = user.get("password");
    }

    @Override
    public String toString() {
        return "\n{\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\"\n" +
                "}";
    }
}
