<%-- 
    Document   : add_product
    Created on : Mar 13, 2025, 10:28:45 AM
    Author     : hungt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add product</h1>
        <form action="ProductController" method="GET">
            <input type="hidden" name="command" value="ADD"/>
            Product Name: <input type="text" name="prodName" required><br>
            Unit: <input type="text" name="prodUnit" required><br>
            Category:
            <select name="categoryList" required>
                <c:forEach var="cat" items="${categoryList}">
                    <!-- Use category ID as the value and display category name and description as label -->
                    <option value="${cat.catID}">${cat.catName} - ${cat.catDesc}</option>
                </c:forEach>
            </select><br>
            Price: <input type="number" name="prodPrice" required><br>
            <input type="submit" value="Add">
        </form>
        
        <button type="submit" onclick="location.href='ProductController'"/>Show product list
    </body>
</html>
