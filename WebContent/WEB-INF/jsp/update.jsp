<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集選択画面</title>
</head>
<body>
<h2>編集する本を選択してください</h2>
<form action="/PrototypeBook/Update" method="get">
<table border="">
        <tr>
        <th></th>
            <th>書籍名</th>
            <th>価格</th>
            <th>ISBN</th>
            <th>評価</th>
        </tr>

<c:forEach var="book" items="${bookList}">

        <tr>

        <td><input type="text" value=""></td>
        <td><input type="text" name="editTitle" value="${book.title}"></td>
        <td><input type="text" name="editPrice" value="${book.price}"></td>
        <td><input type="text" name="editIsbn" value="${book.isbn}"></td>
        <td><input type="text" name="editEvaluation" value="${book.evaluation}"></td>
 
        </tr>

</c:forEach>

</table>
<br><input type="submit" value="編集完了">
</form>
</body>
</html>