<%-- 
    Document   : category_dropdown
    Created on : Mar 13, 2025, 11:51:00 PM
    Author     : hungt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            Category:
            <select name="categoryList" required>
                <c:forEach var="cat" items="${categoryList}">
                    <!-- Use category ID as the value and display category name and description as label -->
                    <option value="${cat.catID}">${cat.catName} - ${cat.catDesc}</option>
                </c:forEach>
            </select><br>
    </body>
</html>
