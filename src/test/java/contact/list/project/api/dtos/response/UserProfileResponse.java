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
        if (!(object instanceof UserProfileResponse that)) return false;
        return getV() == that.getV()
                && Objects.equals(getId(), that.getId())
                && Objects.equals(getFirstName(), that.getFirstName())
                && Objects.equals(getLastName(), that.getLastName())
                && Objects.equals(getEmail(), that.getEmail());
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
