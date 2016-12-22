package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.repository.mock.InMemoryUserRepositoryImpl;
import ru.javawebinar.topjava.web.user.AdminRestController;

import java.util.Arrays;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
public class SpringMain {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            adminUserController.create(new User(1, "userName", "email", "password", Role.ROLE_ADMIN));
            UserRepository ur = appCtx.getBean(InMemoryUserRepositoryImpl.class);
            ur.save(new User(null, "test2", "test1@localhost", "test1", Role.ROLE_USER));
            ur.save(new User(null, "test1", "test2@localhost", "test2", Role.ROLE_USER));
            ur.save(new User(null, "test3", "test3@localhost", "test3", Role.ROLE_USER));
            ur.getAll().stream().forEach(System.out::println);
        }
    }
}
