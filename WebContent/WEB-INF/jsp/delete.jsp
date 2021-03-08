<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除画面</title>
</head>
<body>
<h1>削除画面</h1>
<form action="/PrototypeBook/Delete" method="post">
<table border="1">
        <tr>
        <th></th>
            <th>書籍名</th>
            <th>価格</th>
            <th>ISBN</th>
            <th>評価</th>
        </tr>

<c:forEach var="book" items="${bookList}">

        <tr>

        <td><input type="radio" name="delete" value="${book.id}"></td>
            <td>${book.title}</td>
            <td>${book.price}</td>
            <td>${book.isbn}</td>
            <td>${book.evaluation}</td>
        </tr>

</c:forEach>

</table>
<br><input type="submit" value="削除">
</form>

</body>
</html>