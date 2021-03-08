<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/PrototypeBook/css/css.css">
<title>ユーザーログイン画面</title>
</head>
<body>
<h1>ユーザーログインテスト</h1>
<hr>
<form action="/PrototypeBook/Login" method="post">

<table border="1">
<tr><th>ユーザー名</th><th>パスワード</th></tr>
    <tr><td colspan="1"><input type="text" name="userName"></td><td rowspan="1"><input type="password" name="pass"></td></tr>
    <tr><td></td><td><input type="submit" value="ログイン"></td></tr>
    <tr><td></td><td><input type="submit" value="新規登録"></td></tr>

</table>



<!-- <input type="text" name="name"><br>
<input type="password" name="pass"><br>
<input type="submit" value="ログイン"><br>
<input type="submit" value="登録"> -->
</form>
</body>
</html>