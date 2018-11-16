<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>greeting</title>
</head>
<body>

<center><C:out value="${message}"/>
<form method="Get" action="/OperationsServlet">

    <input type="submit" name="index" value="index" >
  <%--  <input type="submit" name="update" value="update">--%>

</form>
</center>
</body>
</html>
