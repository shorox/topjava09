<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Meal list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meal list</h2>
<table>
    <tr>
        <th> </th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
    </tr>
    <c:forEach var="student" items="${form.students}">
        <tr>
            <td><input type="radio" name="studentId" value="${student.studentId}"></td>
            <td><c:out value="${student.surName}"/></td>
            <td><c:out value="${student.firstName}"/></td>
            <td><c:out value="${student.patronymic}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
