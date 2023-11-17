<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 11/16/2023
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add student</h1>
<form action="/student/handle-add" method="post">
    <input type="text" name="name" placeholder="Ho ten">
    <br>
    <input type="number" name="age">
    <br>
    <select name="gen">
        <option value="true">Nam</option>
        <option value="true">Nu</option>
    </select>
    <button type="submit">ADD</button>
</form>
</body>
</html>
