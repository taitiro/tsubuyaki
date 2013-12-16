<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 import="java.util.ArrayList"
 import="java.sql.Timestamp"
 import="beans.TsubuyakiBean"
 import="beans.TsubuyakiArrayBean"
 %>
<jsp:useBean id="allTsubuyaki" class="beans.TsubuyakiArrayBean" scope="application" />
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/tsubuyaki.js"></script>
<title>つぶやき一覧</title>
</head>
<body>
  <h1>つぶやき一覧</h1>
  <table>
    <tr>
      <th>名前</th>
      <th>つぶやき内容</th>
      <th>日時</th>
    </tr>
<%
ArrayList<TsubuyakiBean> tsubuyakiArray = allTsubuyaki.getTsubuyakiArray();
for(TsubuyakiBean tsubuyakiBean : tsubuyakiArray){
%>
    <tr>
      <th><a href="TsubuyakiGetServlet?name=<%= tsubuyakiBean.getName() %>"><%= tsubuyakiBean.getName() %></a></th>
      <td><%= tsubuyakiBean.getValue() %></td>
      <td><%= tsubuyakiBean.getTimestamp().toString()  %></td>
    </tr>
<%
} 
%>
  </table>
<p><a href="write.jsp">書き込みする</a></p>
<p><a href="TsubuyakiGetServlet">更新する</a></p>
<p><a href="admin/index.html">ログインする</a></p>
<% if(request.getRemoteUser() != null){ %>
<p><a href="admin/logout.jsp">ログアウトする</a></p>
<% } %>
<% if(request.isUserInRole("admin")){ %>
<p><a href="admin/userlist.jsp">ユーザー管理</a></p>
<% } %>
<p><a href="TsubuyakiGetServlet">更新する</a></p>
</body>
</html>