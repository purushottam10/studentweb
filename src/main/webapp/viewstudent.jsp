<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>view Student</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

   <%-- to select single row to the data on the page --%>
    <script>
        $(document).ready(function () {
            $('.edit').click(function () {

                var id = $(this).closest(".tr").find('.id').text();
                var studentName = $(this).closest(".tr").find(".studentName").text();
                var age = $(this).closest(".tr").find(".age").text();
                $.post("EditStudent", {
                    id: id,
                    studentName: studentName,
                    age: age

                });
            });
        });

    </script>
</head>
<body>

<center>
    <form action="<c:url value= "/ViewStudent"/>"  method="post">
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
            <tr class="tr">
                <td class="id" id="id" ><c:out value="${student.roll_no}"/></td>
                <td contenteditable="true" class="studentName" ><c:out value="${student.studentName}"/></td>
                <td contenteditable="true" class="age"><c:out value="${student.age}"/></td>
                <td><a href="<c:url value="/DeleteStudent?id="/><c:out value="${student.roll_no}"/>"> Delete</a></td>
                <td> <input type="button" id="edit"  class="edit" value="edit"> </td>
            </tr>
        </c:forEach>

    </table>
    <c:out value="${ message}"></c:out>
</center>
</body>
</html>
