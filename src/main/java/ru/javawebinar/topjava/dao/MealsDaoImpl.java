package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by sharov on 15.12.2016.
 */
public class MealsDaoImpl implements ObjectDao<Meal> {
    private static List<Meal> meals = new CopyOnWriteArrayList<>();
    private static MealsDaoImpl instance = new MealsDaoImpl();

    private MealsDaoImpl() {
    }

    static{
        meals.add(new Meal(0, LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
        meals.add(new Meal(1, LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
        meals.add(new Meal(2, LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
        meals.add(new Meal(3, LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
        meals.add(new Meal(4, LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
        meals.add(new Meal(5, LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));
    }

    public static MealsDaoImpl getInstance(){
        return instance;
    }

    @Override
    public void add(Meal meal){
        meals.add(meal);
    }

    @Override
    public void delete(int mealId){
        meals.remove(mealId);
    }

    @Override
    public void update(int mealId, Meal meal){
        if(meals.size() < mealId) {
            meals.add(mealId, meal);
        }
    }

    @Override
    public List<Meal> getAll(){
        return meals;
    }

    @Override
    public Meal getById(int mealId){
        return meals.get(mealId);
    }
}
