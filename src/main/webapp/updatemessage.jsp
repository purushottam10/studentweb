<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dz-gg-05
  Date: 1/11/18
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>greeting</title>
</head>
<body>

<center><C:out value="${message}"/>
<form method="Get" action="/OperationsServlet">

    <input type="submit" name="index" value="index" >
    <input type="submit" name="update" value="update">

</form>
</center>
</body>
</html>
