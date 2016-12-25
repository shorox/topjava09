package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.DateTimeUtil;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * GKislin
 * 15.09.2015.
 */
@Repository
public class InMemoryMealRepositoryImpl implements MealRepository {
    private Map<Integer, Collection<Meal>> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.MEALS.forEach(p -> save(p, AuthorizedUser.id()));
    }

    @Override
    public Meal save(Meal meal, int userId) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
        }
        Collection<Meal> listMeal;
        if(repository.get(userId) != null) {
            listMeal = repository.get(userId);
            listMeal.stream().forEach(p -> {
                if(p.getId() == meal.getId()){
                    listMeal.remove(meal.getId());
                }
            });
            listMeal.add(meal);
        } else {
            listMeal = Arrays.asList(meal);
        }
        repository.put(userId, listMeal);
        return meal;
    }

    @Override
    public boolean delete(int id, int userId) {
        return repository.get(userId).remove(id);
    }

    @Override
    public Meal get(int id, int userId) {
        return repository.get(userId).stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Meal meal, int userId) {
        save(meal, userId);
    }

    @Override
    public Collection<Meal> getAll(int userId) {
        Collection<Meal> listMeal = repository.get(userId).stream()
                .sorted(Comparator.comparing(Meal::getDateTime))
                .collect(Collectors.toList());
        return listMeal.size() > 0 ? listMeal : Collections.emptyList();
    }

    @Override
    public Collection<Meal> getBetween(LocalDateTime start, LocalDateTime end, int userId) {
        Objects.requireNonNull(start);
        Objects.requireNonNull(end);
        return repository.get(userId).stream()
                .filter(p -> p.getDateTime().compareTo(start) >= 0 && p.getDateTime().compareTo(end) <= 0)
                .collect(Collectors.toList());
    }
}

