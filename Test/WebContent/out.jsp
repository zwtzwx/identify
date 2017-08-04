<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%
//生成一个简单的由四个数字组成的验证码
Random random = new Random();
int a =random.nextInt(10);
int b =random.nextInt(10);
int c =random.nextInt(10);
int d =random.nextInt(10);
String ident = ""+a+b+c+d;

String type = request.getParameter("type");

%>
</head>
<body>



<div style="background-color:#000;width:80px;height:20px;text-align:center;
margin-top:30px;font-weight:bold;font-size:18px;color:#fff"><%=ident %></div>
<br>
<a href="IdentfiServlet?change=2" style="font-size=10px">看不清？</a>
<br><br>
<%
	//验证失败
	if(type != null) {
		
	%>
	
	<p style="color:red">验证码错误</p>
	<%
	}
%>
<!-- 除了要把输入的验证码传过去，还要把生成的验证码传过去，可以用一个隐藏域 -->
<form action="IdentfiServlet" method="post">
请输入你看到的数字:<input type="text" name="word">
<input type="hidden" name="hideword" value="<%=ident %>">
<br><input type="submit" value="发送">
</form>
</body>
</html>