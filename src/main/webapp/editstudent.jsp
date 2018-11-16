
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>edit_detail</title>
</head>
<body>
<form action="<c:url value="/EditStudent"/>", method="post">

  <%--  Roll no<input type="text" name="id" /> </p>--%>
    Name <input type="text" name="name" /> </p>
    Age <input type="text" name="age" /></p>
    <input type="submit" value="Submit">
</form>

</body>
</html>
