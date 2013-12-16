<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>ユーザー削除</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/tsubuyaki.js"></script>
</head>
<body>
  <h1>ユーザー削除</h1>
  <form action="UserDeleteServlet" method="post">
  <label><input type="text" name="name" value=<%= request.getParameter("name") %> readonly>さんのデータを削除します．</label>
  <input type="submit" value="本当によろしいですか？大丈夫な場合はここをクリック">
  <button id="back">戻る</button>
  </form>
</body>
</html>