package contact.list.project.api.enums;

public enum Endpoint {
    SIGN_UP("users"),
    USER_INFO("users/me");

    private final String ENDPOINT;

    Endpoint(String endPoint) {
        this.ENDPOINT = endPoint;
    }

    public String getEndPoint() {
        return ENDPOINT;
    }
}

