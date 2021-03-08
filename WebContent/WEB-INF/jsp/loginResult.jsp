<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン成功画面</title>
</head>
<body>
ようこそ${loginUser.userName}さん<br>

<a href="/PrototypeBook/Main?check=0">マイページへ</a>
</body>
</html>