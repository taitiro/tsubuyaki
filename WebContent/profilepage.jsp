<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.ArrayList" import="java.sql.Timestamp" import="beans.TsubuyakiBean"
  import="beans.TsubuyakiArrayBean" 
  import="beans.UserBean"
  %>
<jsp:useBean id="thisTsubuyakiArray" class="beans.TsubuyakiArrayBean" scope="request" />
<jsp:useBean id="thisUser" class="beans.UserBean" scope="request" />
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/liketwitter.css">
<link rel="stylesheet" type="text/css" href="css/reveal.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="js/tsubuyaki.js"></script>
<script type="text/javascript" src="js/reveal.js"></script>
<title>つぶやき一覧</title>
</head>
<body>
  <header id="top">
    <h1>
      <jsp:getProperty name="thisUser" property="realname" />
      （@<jsp:getProperty name="thisTsubuyakiArray" property="name" />）さんのつぶやき一覧
    </h1>
    <div class="desc">
      <a href="<jsp:getProperty name="thisUser" property="homepage" />">
      <img src="<jsp:getProperty name="thisUser" property="icon" />" class="icon">
      </a>
      <jsp:getProperty name="thisUser" property="userdesc" /><br />
      住所：<address><jsp:getProperty name="thisUser" property="address" /></address> 権限：<jsp:getProperty name="thisUser" property="role" />
    </div>
    <p class="topHeader">
      <a href="TsubuyakiGetServlet">TOPへ戻る</a>
      <%
          if (request.isUserInRole("admin")) {
      %>
      <a href="#deleteModal" data-reveal-id="deleteModal">このユーザーのつぶやきを削除</a>
      <%
          }
      %>
    </p>
  </header>
  <article>
    <%
        ArrayList<TsubuyakiBean> tsubuyakiArray = thisTsubuyakiArray.getTsubuyakiArray();
        for (TsubuyakiBean tsubuyakiBean : tsubuyakiArray) {
    %>
    <section class="item">
      <h2>
        <a href="TsubuyakiGetServlet?name=<%=tsubuyakiBean.getName()%>"><%=tsubuyakiBean.getRealName()%>(@<%=tsubuyakiBean.getName()%>)</a>
      </h2>
      <p class="tsubuyaki"><%=tsubuyakiBean.getValue()%></p>
      <p class="date"><%=tsubuyakiBean.getTimestamp().toString()%></p>
    </section>
    <%
        }
    %>
  </article>
  <footer>
    <p>このページは<a href="http://c-brains.jp/blog/wsg/09/09/29-225118.php">「tweetage」</a>というCSSテンプレートを改造して使用しています．</p>
    <%
        if (request.isUserInRole("admin")) {
    %>
    <div id="deleteModal" class="reveal-modal">
      <form action="TsubuyakiDeleteServlet" method="post">
        <input type="hidden" name="name" value="<jsp:getProperty name="thisTsubuyakiArray" property="name" />">
        <input type="submit" value="本当に削除してもいいですか？">
      </form>
    </div>
    <%
        }
        request.setAttribute("thisTsubuyakiArray", null);
        request.setAttribute("thisUser", null);
    %>
  </footer>
</body>
</html>