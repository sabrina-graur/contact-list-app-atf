package contact.list.project.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataGenerator {

    private static final Logger LOG = LogManager.getLogger(DataGenerator.class);
    private static final String EMAIL_DOMAIN = "@gmail.com";
    static String LengthValidationMessage = "Length must be a positive integer.";

    public static String generateRandomEmail(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException(LengthValidationMessage);
        }
        String allowedChars = "abcdefghijklmnopqrstuvwxyz1234567890-_.";
        String temp = RandomStringUtils.random(length, allowedChars);
        String email = temp.substring(0, temp.length() - EMAIL_DOMAIN.length()) + EMAIL_DOMAIN;
        LOG.info("The random email with {} length was generated", length);
        return email;
    }

    public static String generateRandomAlphabeticValue(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException(LengthValidationMessage);
        }
        String randomAlphabetic = RandomStringUtils.randomAlphabetic(length);
        String capitalizedWord = randomAlphabetic.substring(0, 1).toUpperCase() + randomAlphabetic.substring(1).toLowerCase();
        LOG.info("The random alphabetic String with {} length was generated", length);
        return capitalizedWord;
    }

    public static String generateRandomAlphanumericValue(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException(LengthValidationMessage);
        }
        LOG.info("The random alphanumeric String with {} length was generated", length);
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String generateNumericValue(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException(LengthValidationMessage);
        }
        LOG.info("Generating a random numeric string with length {}", length);
        return RandomStringUtils.randomNumeric(length);
    }
}
