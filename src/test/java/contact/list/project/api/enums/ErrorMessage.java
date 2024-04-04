package contact.list.project.api.enums;

public enum ErrorMessage {
    EMPTY_FIRST_NAME("User validation failed: firstName: Path `firstName` is required."),
    EMPTY_LAST_NAME("User validation failed: lastName: Path `lastName` is required."),
    EMPTY_EMAIL("User validation failed: email: Expected a string but received a null"),
    EMPTY_PASSWORD("User validation failed: password: Path `password` is required."),
    DUPLICATE_EMAIL("Email address is already in use"),
    WRONG_PASSWORD_LENGTH("User validation failed: password: Path `password` (`123`) is shorter than the minimum allowed length (7).");

    String errorMessageName;

    ErrorMessage(String errorMessageName) {
        this.errorMessageName = errorMessageName;
    }

    public String getErrorMessageName() {
        return errorMessageName;
    }
}
