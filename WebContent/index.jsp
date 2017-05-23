<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Welcome to Letter Automation</p>

<form action="login" name="login">
	Username: <input type="text" name="username">
	Password: <input type="password" name="password">
	<% if (session.getAttribute("login_fail_msg")!=null)%>
    	<p> ${sessionScope.login_fail_msg}</p>
	<input type="submit">
</form>

</body>
</html>