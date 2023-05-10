<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New Customer</title>
  </head>
  <body>
    <%@include file="layout/header.jsp" %>
    <h1>New Customer</h1>
    <form action="doCreateCustomer" method="POST">
      <label for="name">Name: </label><input type="text" id="name" name="name" /><br />
      Gender: <select name="gender">
        <option value="1">Female</option>
        <option value="2">Male</option>
      </select><br>
      <label for="dob">Date of Birth (dd/mm/yyyy): </label><input type="text" id="dob" name="dob" /> <br />
      <input type="submit" value="Submit" />
    </form>
  </body>
</html>
