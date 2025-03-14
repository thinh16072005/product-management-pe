<%-- 
    Document   : edit_product
    Created on : Mar 13, 2025, 10:48:09 AM
    Author     : hungt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product</title>
    </head>
    <body>
        <h1>Edit Product</h1>
        <form action="ProductController" method="GET">
            <input type="hidden" name="command" value="UPDATE">
            <input type="hidden" name="prodId" value="${PRODUCT.prodId}">
        <table border="0">
            <tbody>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name"
                               value="${PRODUCT.prodName}"></td>
                </tr>
                <tr>
                    <td>Unit: </td>
                    <td><input type="text" name="unit"
                               value="${PRODUCT.prodUnit}"></td>
                </tr>
                <tr>
                    <td>Category: </td>
                    <td><input type="text" name="cateogry"
                               value="${PRODUCT.catName}"></td>
                </tr>
                <tr>
                    <td>Unit: </td>
                    <td><input type="text" name="price"
                               value="${PRODUCT.prodPrice}"></td>
                </tr>
                <tr>
                    <input type="submit" value="UPDATE" class="save" />
                </tr>
            </tbody>
        </table>
        </form>
    </body>
</html>
