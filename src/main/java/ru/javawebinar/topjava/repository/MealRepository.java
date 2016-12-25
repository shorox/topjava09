package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
public interface MealRepository {
    Meal save(Meal meal, int userId);

    boolean delete(int id, int userId);

    Meal get(int id, int userId);

    void update(Meal meal, int userId);

    Collection<Meal> getAll(int userId);

    Collection<Meal> getBetween(LocalDateTime start, LocalDateTime end, int userId);
}
