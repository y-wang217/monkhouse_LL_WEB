<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#isLtd").click(function(){
    	$("#ltd_div").toggle(this.checked);
    })
});
</script>
</head>
<body>
	Long Term Disability: <input type="checkbox" name="ltd_jurisprudence" id="isLtd">
		<div id="ltd_div" style="display:none">
			<p id="ltd">Breach of Contract: 						<input type="checkbox" name="isUseBreachOfContract"></p>
			<p id="ltd">LTD Jurisprudence: 							<input type="checkbox" name="isUseLtdJurisprudence"></p>
			<p id="ltd">Punitive Damages in the context of LTD: 	<input type="checkbox" name="isUsePunitiveDamagesLtd"></p>
			<p id="ltd">Moving Forward in the context of LTD: 		<input type="checkbox" name="isUseMovingForwardLtd"></p>
		</div><br>
	<input type="submit">
</body>
</html>