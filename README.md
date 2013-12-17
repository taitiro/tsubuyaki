tsubuyaki - CMS like twitter ( a exercises for Web Aplication)
=====
つぶやき掲示板みたいなもの．

#プログラム構造
※特に明記がない限り拡張子は.java

##database（tsubuyakidb）
###tsubuyakiテーブル
-name（つぶやいたユーザー名，VARCHAR型255文字まで）
-value（つぶやきの内容，VARCHAR型140文字まで）
-data（つぶやいた日時，Timestamp型）

###userauthテーブル
-name（ユーザー名，VARCHAR型255文字）
-password（パスワード（MD5で暗号化して格納），CHAR型140文字）

###userroleテーブル
-name（ユーザー名，VARCHAR型255文字）
-role（ロール，VARCHAR型255文字）

###profileテーブル
-name		ユーザー名（必須）
-realname	ユーザーの表示名
-icon		アイコン画像のURL
-userdesc		自己紹介文
-address		住所
-homepage	ホームページURL

##Model

###Beans（Beanのパッケージ）
-TsubuyakiBean（つぶやきを格納する）
--つぶやいたユーザー名（必須）
--つぶやきの内容（必須）
--つぶやいた日時（必須）

-TsubuyakiArrayBean（つぶやきの集合を格納する）
--集合の名前
--TsubuyakiBeanのリスト（ArrrayList）

-UserBean（ユーザーを格納する）
--ユーザー名（必須）
--パスワード
--ユーザーの表示名
--アイコン画像のURL
--自己紹介文
--住所
--ホームページURL

-UserArrayBean（ユーザーの集合を格納する）
--UserBeanのリスト（ArrrayList）

###dao
-DAOBase（データベースへの接続）
-TsubuyakiDAO（つぶやき関連のデータベース操作）
-UserDAO（ユーザー関連のデータベース操作）

###exception
-DatabaseException（データベース関連の例外．ただServletExceptionをオーバーライドしているだけだったり）

###parameter
-DatabaseParameter（データベース接続の際のパラメータを格納）

###filter
-ExampleFilter（いつもの）

##Controller

##Controller
###Controler
-TsubuyakiGetServlet（つぶやきを取得するという要求を受け取る）
-TsubuyakiAddServlet（つぶやきを追加するという要求を受け取る）
-TsubuyakiDeleteServlet（つぶやきを削除するという要求を受け取る）
-UserGetServlet（ユーザーを取得するという要求を受け取る）
-UserAddServlet（ユーザーを追加するという要求を受け取る）
-UserEditServlet（ユーザーを編集するという要求を受け取る）
-UserDeleteServlet（ユーザーを削除するという要求を受け取る）
-UsersGetServlet（ユーザーの集合を取得するという要求を受け取る）

##View
###WebContent
-admin
--index.html（中身を隠してるだけ．まぁログインするときの宛先として利用もしていたり）
--userlist.jsp（ユーザー一覧画面を表示．admin限定）
--useradd.jsp（ユーザー追加画面を表示．admin限定）
--userdelete.jsp（ユーザー削除画面を表示．admin限定）
--useredit.jsp（ユーザー編集画面を表示．adminは全ユーザー，userは自分のみ）
-js（色々やってます）
-css（面倒なんであんま手を付けたくないなー）
index.jsp（サーバコンテキストに格納された全つぶやきを表示）
write.jsp（書き込み画面を表示．admin,user限定）
profilepage.jsp（プロフィール画面を表示．ただしこれを直接参照することはできない※必ずTsubuyakiGetServlet?name=ユーザー名から呼び出す）

#ワークフロー
##ログイン
1.ログイン必要なページ
2.login.html
3.j_security_check（Tomcatの機能）
4.userauth（データベースのテーブル）
5.j_security_check（Tomcatの機能）
6.ログイン必要なページorエラー

##ログアウト
1.logout.jsp

##読込（TsubuyakiBeanとTsubuyakiArrayBeanを使用）
1.TsubuyakiGetServlet
2.TsubuyakiDAO（DAOBaseをextend，以下省略）
3.tsubuyaki（データベースのテーブル）
4.TsubuyakiDAO
5.TsubuyakiGetServlet
6.index.jsp

##書き込み（TsubuyakiBeanを使用）
1.write.jsp
2.TsubuyakiAddServlet
3.TsubuyakiDAO
4.tsubuyaki（データベースのテーブル）
5.TsubuyakiDAO
6.TsubuyakiAddServlet
7.TsubuyakiGetServlet
8.index.jsp

##ユーザーのつぶやき一覧（UserBeanとTsubuyakiArrayBeanとTsubuyakiArrayBeanを使用）
1.TsubuyakiGetServlet
2.TsubuyakiDAO
3.tsubuyaki（データベースのテーブル）
4.TsubuyakiDAO
5.UserDAO
6.profile,userauth（データベースのテーブル）
7.UserDAO
8.TsubuyakiGetServlet
9.profilepage.jsp

##ユーザー一覧（UserArrayBeanとUserBeanを使用）
1.UsersGetServlet
2.UserDAO
3.profile,userauth（データベースのテーブル）
4.UserDAO
5.UsersGetServlet
6.userlist.jsp

##ユーザー追加（UserBeanを使用）※編集・削除もだいたい同じ
1.UserAddServlet
2.UserDAO
3.profile,userauth（データベースのテーブル）
4.UserDAO
5.UsersGetServlet
6.userlist.jsp