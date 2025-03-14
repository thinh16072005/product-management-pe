<%-- 
    Document   : category_list
    Created on : Mar 13, 2025, 10:46:48 AM
    Author     : hungt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category List</title>
    </head>
    <body>
        <h1>Category List</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Operations</th>
                </tr>
            </thead>
        <c:forEach var="tempCategory" items="${categoryList}">
                <!-- set up a link for each category -->
                <c:url var="tempLink" value="CategoryController">
                    <c:param name="command" value="LOAD"></c:param>
                    <c:param name="categoryId" value="${tempCategory.catID}"></c:param>
                </c:url>
                <!-- set up a link to delete a category -->
                <c:url var="deleteLink" value="CategoryController">
                    <c:param name="command" value="DELETE"></c:param>
                    <c:param name="categoryId" value="${tempCategory.catID}"></c:param>
                </c:url>

                    <tr>
                        <td> ${tempCategory.catID}</td>
                        <td> ${tempCategory.catName}</td>
                        <td> ${tempCategory.catDesc}</td>
                        <td> <a href="${tempLink}">Edit</a>
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure?')))return false">Delete</a>
                    </tr>
        </c:forEach>
        </table>
        <button type="submit" onclick="location.href='add_category.jsp'"/>Add category
        <button type="submit" onclick="location.href='ProductController'"/>Show product list
    </body>
</html>
