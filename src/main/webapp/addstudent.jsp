<%--
  Created by IntelliJ IDEA.
  User: dz-gg-05
  Date: 31/10/18
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>addStudent</title>
</head>
<body>


    <form action="<c:url value= "/AddStudent"/>", method="get">


        Name <input type="text" name="name"   required/> </p>
       Age <input type="text" name="age"
                  required/></p>
        <input type="submit" value="Submit">

    </form>
</body>
</html>
