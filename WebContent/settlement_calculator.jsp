<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Settlement Calculator</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	type="text/javascript" src="js/settlement.js"></script>

</head>
<body>
	<div id="test">
		<p>
			Years of Service: <input type="text" name="years_of_service"> <br>

			<select name="client_occupation">
				<option selected="selected" value="1">[Select the category for the position]</option>
				<option value="2">Upper Management (150k+)</option>
				<option value="1.5">Middle Management (between 75k and
					150k)</option>
				<option value="1.3">Lower Management (75k-)</option>
				<option value="1.2">Salesperson</option>
				<option value="1.3">Sales Manager</option>
				<option value="1.3">Professional</option>
				<option value="0.8">Labourer</option>
				<option value="0.8">Clerical</option>
				<option value="1.2">Technical</option>
				<option value="1.2">Supervisor</option>
				<option value="1">Social Service</option>
			</select>
		<div id="round"></div>
		<div id="raw"></div>
	</div>
</body>
</html>