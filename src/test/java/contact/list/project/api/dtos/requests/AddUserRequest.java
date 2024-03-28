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

    public AddUserRequest() {
    }

    @JsonGetter("email")
    public String getJsonEmail() {
        if (email != null) {
            return email;
        }
        return "";
    }

    public String getEmail() {
        return email;
    }

    @JsonGetter("password")
    public String getJsonPassword() {
        if (password != null) {
            return password;
        }
        return "";
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}