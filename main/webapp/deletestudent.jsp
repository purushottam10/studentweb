<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
