<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dz-gg-05
  Date: 2/11/18
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>deletestudent</title>
</head>
<body>
<form method="get" , action="<c:url value= "/DeleteStudent"/>">
     Id<input type="text" name="id" /> </p>
    <input type="submit" value="Submit">
</form>
</body>
</html>
