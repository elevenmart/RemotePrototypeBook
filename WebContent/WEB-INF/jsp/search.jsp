<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索内容</title>
</head>
<body>

<p>検索したい内容を書いてください</p>

<form action="/PrototypeBook/Main" method="post">
検索ワード：<input type="hidden" name="key" value="1">
<input type="text" name="keyword">
<br>
<input type="submit" value="検索">
</form>

<form action="/PrototypeBook/Main" method="post">
ISBN：<input type="hidden" name="key" value="2">
<input type="text" name="isbn">
<br>
<input type="submit" value="検索">
</form>
</body>
</html>