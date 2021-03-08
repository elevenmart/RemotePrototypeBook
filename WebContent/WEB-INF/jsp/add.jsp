<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>追加画面</h1><br>
<form action="/PrototypeBook/Add" method="post">
本のタイトル：<input type="text" name ="title"><br>
価格：<input type="text" name ="price"><br>
ISBN：<input type="text" name ="isbn"><br>
評価：<input type="text" name ="evaluation"><br>
<input type="submit" value="追加">
</form>
<a href="/PrototypeBook/Login">戻る</a>
</body>
</html>