package contact.list.project.api.enums;

import org.apache.logging.log4j.LogManager;

public enum Endpoint {
    SIGN_UP("users"),
    USER_INFO("users/me");

    private final String ENDPOINT;

    Endpoint(String endPoint) {
        this.ENDPOINT = endPoint;
    }

    public String getEndPoint() {
        LogManager.getLogger().info("Retrieving the endpoint: {}", ENDPOINT);
        return ENDPOINT;
    }
}
