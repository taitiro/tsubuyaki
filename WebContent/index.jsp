<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.ArrayList" import="java.sql.Timestamp" import="beans.TsubuyakiBean"
  import="beans.TsubuyakiArrayBean"%>
<jsp:useBean id="allTsubuyaki" class="beans.TsubuyakiArrayBean" scope="application" />
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
      <%
          if (request.getRemoteUser() == null) {
      %>
      ゲスト
      <%
          } else {
              out.print(request.getRemoteUser());
          }
      %>
      さんこんにちは！
    </h1>
    <p class="topHeader">
      <a href="TsubuyakiGetServlet">更新する</a>
      <%
          if (request.getRemoteUser() == null) {
      %>
      <a href="admin/index.html">ログインする</a>
      <%
          } else {
      %>
      <a href="#writeModal" data-reveal-id="writeModal">書込する</a> <a href="logout.jsp">ログアウトする</a>
      <%
          }
      %>
      <%
          if (request.isUserInRole("admin")) {
      %>
      <a href="admin/userlist.jsp">ユーザー管理</a>
      <%
          } else if (request.getRemoteUser() != null) {
      %>
      <a href="admin/useredit.jsp?name=<%=request.getRemoteUser()%>">プロフィール編集</a>
      <%
          }
      %>
    </p>
  </header>
  <article>
    <%
        ArrayList<TsubuyakiBean> tsubuyakiArray = allTsubuyaki.getTsubuyakiArray();
        for (TsubuyakiBean tsubuyakiBean : tsubuyakiArray) {
    %>
    <section class="item" style="background-image: url('<%=tsubuyakiBean.getIcon()%>')">
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
    <p>
      このページは<a href="http://c-brains.jp/blog/wsg/09/09/29-225118.php">「tweetage」</a>というCSSテンプレートを改造して使用しています．
    </p>
    <%
        if (request.getRemoteUser() != null) {
    %>
    <div id="writeModal" class="reveal-modal">
      <h1>つぶやきを書き込む</h1>
      <form action="TsubuyakiAddServlet" method="post">
        <div>
          <label>ユーザー名<input type="text" name="name" value="<%=request.getRemoteUser()%>" readonly></label>
        </div>
        <div>
          <label>つぶやき内容<textarea name="value" required></textarea></label>
        </div>
        <div>
          <input type="submit" value="送信"> <input type="reset" value="リセット">
        </div>
      </form>
      <a class="close-reveal-modal">&#215;</a>
    </div>
    <%
        }
    %>
  </footer>
</body>
</html>