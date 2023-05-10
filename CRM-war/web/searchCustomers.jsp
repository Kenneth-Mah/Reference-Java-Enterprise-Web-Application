<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Customers</title>
    </head>
    <body>
        <%@include file="layout/header.jsp" %>
        <h1>Customers</h1>
        <form action="searchCustomers" method="POST">
            <input type="text" name="searchValue" />
            <input type="submit" value="Search" />
        </form>
        <c:forEach var="customer" items="${customers}">
            <div style="border: 1px brown solid; padding: 10px;">
                Id: ${customer.id}<br />
                Name: ${customer.name}<br />
                Gender: ${(customer.gender == 1)? "Female" : "Male"}<br />
                DOB: ${customer.dob}<br />
                Created: ${customer.created}<br />

                <form action="editCustomer" method="POST">
                    <input type="hidden" name="cId" value="${customer.id}">
                    <input type="submit" value="Edit Customer">
                </form>
                <form action="doDeleteCustomer"  method="POST">
                    <input type="hidden" name="cId" value="${customer.id}">
                    <input type="submit" value="Delete Customer">
                </form>
            </div>
        </c:forEach>
    </body>
</html>
