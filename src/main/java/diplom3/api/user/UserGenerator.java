package diplom3.api.user;

import diplom3.api.models.User;

import static diplom3.utils.Utils.faker;

public class UserGenerator {
    public static User randomUser() {
        return new User()
                .withEmail(faker.internet().emailAddress())
                .withPassword(faker.internet().password(7, 10))
                .withName(faker.name().username());
    }
}
