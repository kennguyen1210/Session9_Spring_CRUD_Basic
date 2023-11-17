<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 11/17/2023
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit student</h1>
<form action="/student/handle-edit" method="post">
    <input type="text" name="id" value="${editStudent.id}" readonly>
    <br>
    <input type="text" name="name" value="${editStudent.name}">
    <br>
    <input type="number" name="age" value="${editStudent.age}">
    <br>
    <select name="gen">
        <option value="true" ${editStudent.gen?"selected":""}>Nam</option>
        <option value="true" ${!editStudent.gen?"selected":""}>Nu</option>
    </select>
    <button type="submit">EDIT</button>
</form>
</body>
</html>
