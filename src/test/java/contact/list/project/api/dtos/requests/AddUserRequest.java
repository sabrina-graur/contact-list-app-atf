package contact.list.project.api.dtos.requests;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonGetter;

public class AddUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public AddUserRequest(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @JsonGetter("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonGetter("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonGetter("email")
    public String getEmail() {
        return email;
    }

    @JsonGetter("password")
    public String getPassword() {
        return password;
    }
}
