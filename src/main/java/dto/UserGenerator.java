package dto;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static User getRandomUser() {
        User user = new User();
        user.setName(RandomStringUtils.randomAlphabetic(10));
        user.setEmail(RandomStringUtils.randomAlphabetic(10) + "@mail.ru");
        user.setPassword(RandomStringUtils.randomAlphabetic(10));
        return user;
    }
}
