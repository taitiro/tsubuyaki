<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="beans.UserBean"
    import="dao.UserDAO"
    %>
<% 
UserDAO userDAO = new UserDAO();
UserBean thisUser = userDAO.getUser(request.getParameter("name"));
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>ユーザー編集</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/tsubuyaki.js"></script>
<script type="text/javascript" src="../js/md5.js"></script>
</head>
<body>
  <h1>ユーザー編集</h1>
  <% if((request.getParameter("name").equals(request.getRemoteUser())) || (request.isUserInRole("admin"))){ %>
  <form action="UserEditServlet" method="post" id="form">
  <div>
  <label>ユーザーID（変更できません）:<input type="text" name="name" value="<%= request.getParameter("name") %>" readonly></label>
  </div>
  <div>
  <label>パスワード:<input type="password" name="password" class="alphabet rawPassword" required></label>
  </div>
  <div>
  <label>スクリーンネーム:<input type="text" name="realname" value="<%= thisUser.getRealname() %>"></label>
  </div>
  <div>
  <label>自己紹介:<textarea name="userdesc"><%= thisUser.getUserdesc() %></textarea></label>
  </div>
  <div>
  <label>住所:<input type="text" name="address" value="<%= thisUser.getAddress() %>"></label>
  </div>
  <div>
  <label>ホームページ:<input type="url" name="homepage" value="<%= thisUser.getHomepage() %>"></label>
  </div>
  <div>
  <label>アイコン画像URL:<input type="url" name="icon" value="<%= thisUser.getIcon() %>"></label>
  </div>
  <div>
  <fieldset>ロール：
  <label><input type="radio" name="role" value="admin" />admin</label>
  <label><input type="radio" name="role" value="user" checked/>user</label>
  </fieldset>
  </div>
  <div>
  <input type="submit" value="送信">
  <input type="reset" value="リセット">
  <button id="back">戻る</button>
  </div>
  </form>
  <% }else{ %>
  userさんは自分以外の情報は編集できません
  <% } %>
</body>
</html>