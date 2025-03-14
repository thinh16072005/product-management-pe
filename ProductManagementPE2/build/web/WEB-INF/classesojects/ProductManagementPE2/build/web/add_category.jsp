<%-- 
    Document   : add_category
    Created on : Mar 13, 2025, 10:47:58 AM
    Author     : hungt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
    </head>
    <body>
        <h1>Add Category</h1>
        <form action="CategoryController" method="GET">
            <input type="hidden" name="command" value="ADD"/>
            Category Name: <input type="text" name="catName" required><br>
            Description: <input type="text" name="catDesc" required><br>
            <input type="submit" value="ADD">
        </form>
        
        <button type="submit" onclick="location.href='CategoryController'"/>Show category list
    </body>
</html>
