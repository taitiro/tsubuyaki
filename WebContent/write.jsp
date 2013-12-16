<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/tsubuyaki.js"></script>
<title>つぶやきを書き込む</title>
</head>
<body>
  <h1>つぶやきを書き込む</h1>
  <form action="TsubuyakiAddServlet" method="post">
    <div>
      <label>ユーザー名：<input type="text" name="name" value="<%= request.getRemoteUser() %>" readonly></label>
    </div>
    <div>
      <label>つぶやき内容<textarea name="value" required></textarea></label>
    </div>
    <div>
      <input type="submit" value="送信"> <input type="reset" value="リセット">
      <button id="back">戻る</button>
    </div>
  </form>
</body>
</html>