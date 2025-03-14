<%-- 
    Document   : product_list
    Created on : Mar 13, 2025, 10:39:45 AM
    Author     : hungt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
    </head>
    <body>
        <h1>List of Products</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Unit</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Operations</th>
                </tr>
            </thead>
            <tbody>                    
            <c:forEach var="tempProduct" items="${productList}">
                <!-- set up a link for each product -->
                <c:url var="tempLink" value="ProductController">
                    <c:param name="command" value="LOAD"></c:param>
                    <c:param name="productId" value="${tempProduct.prodId}"></c:param>
                </c:url>
                <!-- set up a link to delete a student -->
                <c:url var="deleteLink" value="ProductController">
                    <c:param name="command" value="DELETE"></c:param>
                    <c:param name="productId" value="${tempProduct.prodId}"></c:param>
                </c:url>

                    <tr>
                        <td> ${tempProduct.prodId}</td>
                        <td> ${tempProduct.prodName}</td>
                        <td> ${tempProduct.prodUnit}</td>
                        <td> ${tempProduct.catName}</td>
                        <td> ${tempProduct.prodPrice}</td>
                        <td> <a href="${tempLink}">Edit</a>
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure?')))return false">Delete</a>
                    </tr>
            </c:forEach>
        </tbody>
        </table>
        
        <button type="button" onclick="location.href='ProductController?command=SHOW_ADD_PRODUCT'"/>Add product
        
        <button type="button" onclick="location.href='CategoryController'"/>Show category list
        
    </body>
</html>
