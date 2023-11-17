<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 11/16/2023
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/upload/upload-image" method="post" enctype="multipart/form-data">
    <input type="file" name="image" multiple>
    <button type="submit">Upload</button>
</form>
</body>
</html>
