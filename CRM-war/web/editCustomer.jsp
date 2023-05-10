<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Customer</title>
  </head>
  <body>
    <%@include file="layout/header.jsp" %>
    <h1>Edit Customer</h1>
    <form action="doUpdateCustomer" method="POST">
      <input type="hidden" name="cId" value="${customer.id}" />
      <label for="name">Name: </label><input type="text" id="name" name="name" value="${customer.name}" /><br />
      Gender: <select name="gender">
        <option value="1" <c:if test="${customer.gender == 1}">selected</c:if>>Female</option>
        <option value="2" <c:if test="${customer.gender == 2}">selected</c:if>>Male</option>
      </select><br>

      <label for="dob">Date of Birth (dd/mm/yyyy): </label><input type="text" id="dob" name="dob" value="<fmt:formatDate pattern = "dd/MM/yyyy"
      value = "${customer.dob}" />" /> <br />
      <input type="submit" value="Submit" />
    </form>
  </body>
</html>
