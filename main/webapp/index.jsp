<%@ page import="java.sql.*" %>
<html>
<head>
    <title>student record </title>
</head>
<body>
<h> <center>Student Record </center> </h>
<%
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    try {
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false", "system", "admin123");
        statement= connection.createStatement();
        resultSet=statement.executeQuery("select * from student");
        while (resultSet.next()){

%>
<table>
    <tbody>
    <tr>
        <td><%= resultSet.getInt(1)%></td>
        <td><%= resultSet.getString(2)%> </td>
        <td><%= resultSet.getInt(3)%></td>

    </tr>
    </tbody>
</table>
<%
        }


    } catch (SQLException e) {
        e.printStackTrace();
    }

%>
</body>
</html>