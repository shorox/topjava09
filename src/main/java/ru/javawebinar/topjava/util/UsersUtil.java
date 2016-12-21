package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sharov on 21.12.2016.
 */
public class UsersUtil {
    public static final List<User> USERS = Arrays.asList(
            new User(0, "User", "user@localhost", "user", Role.ROLE_USER),
            new User(1, "Admin", "admin@localhost", "admin", Role.ROLE_ADMIN)
    );
}
