<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import = "java.sql.*" %>
<%@ page import = "javax.sql.*" %>
<%
Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","root");
           Statement statement = connection.createStatement() ;
          ResultSet resultset = statement.executeQuery("select username,email,phone from login") ;
       %>
       <h1>Employee Details</h1>
      <TABLE BORDER="1">
      <TR>
      <TH>Username</TH>
      <TH>Email</TH>
      <TH>Phone number</TH>
      </TR>
      <% while(resultset.next()){ %>
      <TR>
       <TD> <%= resultset.getString(1) %></td>
       <TD> <%= resultset.getString(2) %></TD>
       <TD> <%= resultset.getString(3) %></TD>
      </TR>
      <% } %>
     </TABLE>
</body>
</html>