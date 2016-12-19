package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface ObjectDao<T> {
    void add(T t);
    void delete(int id);
    void update(int id, T t);
    List<T> getAll();
    Meal getById(int id);
}
