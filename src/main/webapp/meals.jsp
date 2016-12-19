<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://ru.javawebinar.topjava/functions" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Meal list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meal list</h2>
<table border=1>
    <thead>
    <tr>
        <th>Время</th>
        <th>Описание</th>
        <th>Калории</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mealWithExceedList}" var="m">
        <jsp:useBean id="m" scope="page" type="ru.javawebinar.topjava.model.MealWithExceed" />
        <tr class = ${m.isExceed() ? 'exceeded' : 'normal'}>
            <td><c:out value="${f:formatDateTime(m.getDateTime())}" /></td>
            <td><c:out value="${m.getDescription()}" /></td>
            <td><c:out value="${m.getCalories()}" /></td>
            <td><a href="?action=update&id=${m.getId()}">Изменить</a></td>
            <td><a href="?action=delete&id=${m.getId()}">Удалить</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form method="post">

</form>
<p><a href="?action=add">Добавить</a></p>
</table>

</body>
</html>
