<%--
  Created by IntelliJ IDEA.
  User: dz-gg-05
  Date: 2/11/18
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete msg</title>
</head>
<body>

<center>   <c:out value="${message}"/>
    <form method="Get" action="<C:url  value= "/OperationsServlet"/>" >

        <input type="submit" name="index" value="index" >
        <input type="submit" name="update" value="delete">

    </form>
</center>
</body>
</html>
