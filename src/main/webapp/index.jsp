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
