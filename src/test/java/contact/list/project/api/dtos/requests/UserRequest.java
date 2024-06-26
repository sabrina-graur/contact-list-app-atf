package contact.list.project.api.dtos.requests;

import java.util.Map;

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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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
