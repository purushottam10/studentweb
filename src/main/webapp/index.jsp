<%--
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<center>
    <h3> welcome to student pannel </h3><br>
    <br>
    <br>
    <br><br>
    <br>
<form  action="<c:url value="/OperationsServlet"/>", method="post">
    <select name="Operation" >
        <option value="add" selected>add</option>
        <option value="view">view</option>
        <option value="edit">edit</option>
        <option value="delete">delete</option>

    </select>
    <input type="submit" value="Submit">

</form>

    <c:out value="${ message}"></c:out>
</center>
</body>
</html>
--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <form action="<c:url value= "/ViewStudent"/>" , method="post">


        <input type="submit" value="show" name="show">
        <input type="submit" value="add" name="add">

    </form>

    <table class="table ">
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td><c:out value="${student.roll_no}"/></td>
                <td><c:out value="${student.studentName}"/></td>
                <td><c:out value="${student.age}"/></td>
                <td><a href="<c:url value="/DeleteStudent?id="/><c:out value="${student.roll_no}"/>"> Delete</a></td>
                <td> <a href="<c:url value="/EditStudent?id="/><c:out value="${student.roll_no}"/>">Edit</a>
                </td>
            </tr>
        </c:forEach>

    </table>

    <c:out value="${ message}"></c:out>
</center>
</body>
</html>
