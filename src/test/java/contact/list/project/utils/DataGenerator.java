package contact.list.project.utils;

import contact.list.project.configurations.properties.PropertiesManager;
import net.datafaker.Faker;
import org.apache.logging.log4j.LogManager;

import java.util.regex.Pattern;

public class DataGenerator {
    private static final Faker FAKER = new Faker();
    private static final Pattern NAME_PATTERN = Pattern.compile(PropertiesManager.getUserNameRegex());
    private static final Pattern EMAIL_PATTERN = Pattern.compile(PropertiesManager.getEmailRegex());
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PropertiesManager.getPasswordRegex());

    public static String generateRandomEmail() {
        String email;
        do {
            email = FAKER.internet().emailAddress();
        } while (!EMAIL_PATTERN.matcher(email).matches());
        LogManager.getLogger().info("The random email was generated: {}", email);
        return email;
    }

    private static String generateRandomName(String nameType) {
        String name;
        do {
            name = (nameType.equals("first name")) ? FAKER.name().firstName() : FAKER.name().lastName();
        } while (!NAME_PATTERN.matcher(name).matches());
        LogManager.getLogger().info("The random {} was generated: {}", nameType, name);
        return name;
    }

    public static String generateRandomFirstName() {
        return generateRandomName("first name");
    }

    public static String generateRandomLastName() {
        return generateRandomName("last name");
    }

    public static String generateRandomPassword() {
        String password;
        do {
            password = FAKER.internet().password();
        } while (!PASSWORD_PATTERN.matcher(password).matches());
        LogManager.getLogger().info("The random password was generated: {} ", password);
        return password;
    }
}
