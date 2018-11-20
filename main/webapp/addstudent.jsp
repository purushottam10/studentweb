
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>addStudent</title>
</head>
<body>

    <form action="<c:url value= "/AddStudent"/>" method="get">


        Name <input type="text" name="name" pattern="[A-Za-z]+"  required/> </p>
       Age <input type="text" name="age" pattern="[0-9]+"
                  required/></p>
        <input type="submit" value="Submit">

    </form>
</body>
</html>
