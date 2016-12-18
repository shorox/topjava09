<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <c:choose>
            <c:when test="${m.isExceed()}">
                <tr style="color: red">
            </c:when>
            <c:otherwise>
                <tr style="color: green">
            </c:otherwise>
        </c:choose>

            <td><c:out value="${m.getDateTime()}" /></td>
            <td><c:out value="${m.getDescription()}" /></td>
            <td><c:out value="${m.getCalories()}" /></td>
            <td><a href="?action=update">Изменить</a></td>
            <td><a href="?action=delete">Удалить</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form method="post">
    <input type="datetime" />
</form>
<p><a href="?action=add">Добавить</a></p>
</table>

</body>
</html>
