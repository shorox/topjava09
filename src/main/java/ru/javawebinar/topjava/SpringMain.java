package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.repository.mock.InMemoryMealRepositoryImpl;
import ru.javawebinar.topjava.repository.mock.InMemoryUserRepositoryImpl;
import ru.javawebinar.topjava.web.meal.MealRestController;
import ru.javawebinar.topjava.web.user.AdminRestController;

import java.time.LocalDateTime;
import java.time.Month;
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

            new MealRestController().getAll().stream().forEach(System.out::println);
            /*
            UserRepository ur = appCtx.getBean(InMemoryUserRepositoryImpl.class);
            ur.save(new User(null, "test2", "test1@localhost", "test1", Role.ROLE_USER));
            ur.save(new User(null, "test1", "test2@localhost", "test2", Role.ROLE_USER));
            ur.save(new User(null, "test3", "test3@localhost", "test3", Role.ROLE_USER));
            ur.getAll().stream().forEach(System.out::println);

            MealRepository mr = appCtx.getBean(InMemoryMealRepositoryImpl.class);
            mr.save(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500), ur.getAll().get(1).getId().intValue());
            mr.save(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000), ur.getAll().get(1).getId().intValue());
            mr.save(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500), ur.getAll().get(1).getId().intValue());
            mr.save(new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000), ur.getAll().get(1).getId().intValue());
            mr.save(new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500), ur.getAll().get(1).getId().intValue());
            mr.save(new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510), ur.getAll().get(1).getId().intValue());
            mr.getAll(ur.getAll().get(1).getId().intValue()).stream().forEach(System.out::println);
            */
        }
    }
}
