<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 import="java.util.ArrayList"
 import="beans.UserArrayBean"
 %>
<jsp:useBean id="allUsers" class="beans.UserArrayBean" scope="application" />
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/tsubuyaki.js"></script>
<title>ユーザー一覧</title>
</head>
<body>
  <h1>ユーザー一覧</h1>
  <table>
    <tr>
      <th>ユーザーID</th>
      <th>ロール</th>
      <th colspan="2"><a href="useradd.html"> ユーザー作成</a></th>
    </tr>
<%
ArrayList<String[]> usersArray = allUsers.getUsersArray();
for(String[] userArray : usersArray){
%>
    <tr>
      <th><a href="../TsubuyakiGetServlet?name=<%= userArray[0] %>"><%= userArray[0] %></a></th>
      <td><%= userArray[1] %></td>
      <td><a href="useredit.jsp?name=<%= userArray[0] %>" >編集</a></td>
      <td><a href="userdelete.jsp?name=<%= userArray[0] %>" >削除</a></td>
    </tr>
<%
} 
%>
  </table>
<p><a href="UsersGetServlet">更新する</a></p>
<% if(request.getRemoteUser() != null){ %>
<p><a href="logout.jsp">ログアウトする</a></p>
<% } %>
<p><a href="../index.jsp">トップへ戻る</a></p>
</body>
</html>