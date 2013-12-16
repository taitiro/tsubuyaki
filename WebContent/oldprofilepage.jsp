<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 import="java.util.ArrayList"
 import="java.sql.Timestamp"
 import="beans.TsubuyakiBean"
 import="beans.TsubuyakiArrayBean"
 %>
<jsp:useBean id="thisTsubuyakiArray" class="beans.TsubuyakiArrayBean" scope="request" />
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/tsubuyaki.js"></script>
<title><jsp:getProperty name="thisTsubuyakiArray" property="name" />さんのつぶやき一覧</title>
</head>
<body>
  <h1><jsp:getProperty name="thisTsubuyakiArray" property="name" />さんのつぶやき一覧</h1>
  <table>
    <tr>
      <th>名前</th>
      <th>つぶやき内容</th>
      <th>日時</th>
    </tr>
<%
ArrayList<TsubuyakiBean> tsubuyakiArray = thisTsubuyakiArray.getTsubuyakiArray();
for(TsubuyakiBean tsubuyakiBean : tsubuyakiArray){
%>
    <tr>
      <th><a href="TsubuyakiGetServlet?name=<%= tsubuyakiBean.getName() %>"><%= tsubuyakiBean.getName() %></a></th>
      <td><%= tsubuyakiBean.getValue() %></td>
      <td><%= tsubuyakiBean.getTimestamp().toString()  %></td>
    </tr>
<% } %>
  </table>
<% if(request.isUserInRole("admin")){ %>
<form action="TsubuyakiDeleteServlet" method="post">
  <input type="hidden" name="name" value="<jsp:getProperty name="thisTsubuyakiArray" property="name" />">
  <input type="submit" value="つぶやきを全て削除" id="confirmDeleteTsubuyaki">
  </form>
<% }
request.setAttribute("thisTsubuyakiArray", null); %>
<p><a href="TsubuyakiGetServlet">つぶやきページに戻る</a></p>
</body>
</html>