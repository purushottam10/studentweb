<%--
  Created by IntelliJ IDEA.
  User: dz-gg-05
  Date: 1/11/18
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<c:url value="/EditStudent"/>", method="get">

    Id<input type="text" name="id" /> </p>
    Name <input type="text" name="name" /> </p>
    Age <input type="text" name="age" /></p>
    <input type="submit" value="Submit">
</form>

</body>
</html>
