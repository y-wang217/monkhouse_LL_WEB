<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p> Welcome ${sessionScope.UserName} </p>

<form action="user_info.jsp">
    <input type="submit" value="Click to view user info" />
</form>
<form action="generate_letter.jsp">
    <input type="submit" value="Click to create new Lawyer's Letter" />
</form>
<form action="letter_history.jsp">
    <input type="submit" value="Click to view previous letters" />
</form>

</body>
</html>