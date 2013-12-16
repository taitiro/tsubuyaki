<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ認証</title>
</head>
<body>
  <div style="text-align:center">
  <h2>ログアウトしました</h2>
  <br>
  <a href="index.jsp">トップへ</a>
  </div>
<%
session.invalidate();
%>
</body>
</html>
