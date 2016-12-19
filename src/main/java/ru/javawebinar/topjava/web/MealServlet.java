package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealsDaoImpl;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet{
    private static final Logger LOG = getLogger(MealServlet.class);

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        LOG.debug("redirect to meals");

        String action = req.getParameter("action");
        if(action != null && action.equals("delete")){
            MealsDaoImpl.getInstance().delete(Integer.valueOf(req.getParameter("id")));

        }
        req.setAttribute("mealWithExceedList", MealsUtil.getFilteredWithExceeded(MealsDaoImpl.getInstance().getAll(), LocalTime.MIN, LocalTime.MAX, 2000));
        req.getRequestDispatcher("meals.jsp").forward(req, resp);
    }
}
