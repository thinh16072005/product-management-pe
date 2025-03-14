<%-- 
    Document   : index
    Created on : Mar 13, 2025, 10:30:21 AM
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
        <jsp:forward page="ProductController">
            <jsp:param name="command" value="SHOW_ADD_PRODUCT"/>
        </jsp:forward>
    </body>
</html>
