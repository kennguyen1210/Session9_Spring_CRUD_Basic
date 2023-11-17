<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 11/17/2023
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${images}" var="img">
    <img src="${img}" alt="#" width="100" style="object-fit: cover">
    <a href="${img}" target="_blank">Dowload</a>
</c:forEach>
</body>
</html>
