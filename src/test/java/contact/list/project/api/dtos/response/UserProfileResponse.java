package contact.list.project.api.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UserProfileResponse {

    @JsonProperty("_id")
    private String id;

    private String firstName;
    private String lastName;
    private String email;

    @JsonProperty("__v")
    private int v;

    public UserProfileResponse() {
    }

    public UserProfileResponse(String id, String firstName, String lastName, String email, int v) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.v = v;
    }

    public String getId() {
        return id;
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

    public int getV() {
        return v;
    }

    @Override
    public boolean equals(Object object) {
        UserProfileResponse userProfileResponse = (UserProfileResponse) object;
        return v == userProfileResponse.v
                && id.equals(userProfileResponse.id)
                && firstName.equals(userProfileResponse.firstName)
                && lastName.equals(userProfileResponse.lastName)
                && email.equals(userProfileResponse.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getV());
    }

    @Override
    public String toString() {
        return "\nuser: {\n" +
                "  \"id\": \"" + id + "\",\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"v\": " + v + "\n" +
                "}";
    }
}
