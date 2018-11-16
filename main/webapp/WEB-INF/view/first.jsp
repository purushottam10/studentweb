<%--
  Created by IntelliJ IDEA.
  User: dz-gg-05
  Date: 29/10/18
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
  <c:forEach lis="${studentList}" var="student">
      <tr>
          <td>${student.id}</td>
          <td>${student.name}</td>
      </tr>
  </c:forEach>
</body>
</html>
