package contact.list.project.api.dtos.response;

import java.util.Objects;

public class CreateUserResponse {
    private UserProfileResponse user;
    private String token;

    public CreateUserResponse() {
    }

    public UserProfileResponse getUser() {
        return user;
    }

    public void setUser(UserProfileResponse user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object object) {
        CreateUserResponse createUserResponse = (CreateUserResponse) object;
        return this.getUser().equals(createUserResponse.getUser())
                && token.equals(createUserResponse.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getToken());
    }

    @Override
    public String toString() {
        return "\n{" +
                user + ",\n" +
                "  \"token\": \"" + token + "\"\n" +
                "}";
    }
}
