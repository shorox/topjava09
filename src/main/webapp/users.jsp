<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>
    <h2>User list</h2>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Active</th>
            <th>Date registered</th>
            <th>Roles</th>
            <th>Calories per day</th>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.getEmail()}</td>
                <td>${user.password}</td>
                <td>${user.enabled}</td>
                <td>${user.registered}</td>
                <td>${user.roles}</td>
                <td>${user.caloriesPerDay}</td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
