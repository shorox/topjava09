package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
public class MealRestController {

    @Autowired
    private MealService service;

    public List<MealWithExceed> getAll(){
        return MealsUtil.getFilteredWithExceeded(
                service.getAll(AuthorizedUser.id()),
                LocalTime.MIN,
                LocalTime.MAX,
                MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

    public List<MealWithExceed> getAllByFilteredDateTime(
            LocalDate startDate,
            LocalTime startTime,
            LocalDate endDate,
            LocalTime endTime){
        return null;
    }
}
