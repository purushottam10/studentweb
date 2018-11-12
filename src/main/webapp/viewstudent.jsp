
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>view Student</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<center>
<form action="<c:url value= "/ViewStudent"/>", method="post">



    <input type="submit" value="show" name="show">
    <input type="submit" value="index" name="index">

</form>

<table class="table " >
    <tr>
        <th>id </th>
        <th>Name</th>
        <th>Age</th>
    </tr>
<c:forEach items="${studentList}" var="student">
    <tr>
        <td><c:out value="${student.roll_no}"></c:out></td>
        <td><c:out value="${student.studentName}"></c:out></td>
        <td><c:out value="${student.age        }"></c:out> </td>
    </tr>
    </c:forEach>

</table>
</center>
</body>
</html>
