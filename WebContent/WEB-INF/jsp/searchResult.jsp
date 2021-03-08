<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
</head>
<body>



<c:forEach var="book" items="${bookList}">


<table border="1">
<tr><th>ユーザー名</th><th>書籍名</th><th>価格</th><th>ISBN</th><th>評価</th></tr>
    <tr><td colspan="1"></td><td rowspan="1"></td></tr>

    <tr><td>${book.id}</td><td>${book.title}</td></tr>
    <tr><td>${book.price}</td><td>${book.isbn}</td></tr>
    <tr><td>${book.evaluation}</td></tr>

</table>






</c:forEach>


<a href="/PrototypeBook/Login">戻る</a>

</body>
</html>

