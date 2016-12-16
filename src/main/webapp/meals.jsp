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
        <th>id</th>
        <th>Время</th>
        <th>Описание</th>
        <th>Калории</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list_meals}" var="m">
        <tr>
            <td></td>
            <td></td>
            <td><c:out value="${m.getDescription()}" /></td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="">Add User</a></p>
</table>
</body>
</html>
