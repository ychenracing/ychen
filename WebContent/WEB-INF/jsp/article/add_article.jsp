<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建文章</title>
</head>
<body>
	<form:form action="/article/addarticle" method="post"
		commandName="articleForm">

		<form:hidden path="id" />
		<form:input path="title" />

		<form:textarea path="mainBody" cols="400" rows="1000" />

		<form:select path="category">
			<form:option value="java">java</form:option>
			<form:option value="spring">spring</form:option>
			<form:option value="db">db</form:option>
			<form:option value="ds">ds</form:option>
			<form:option value="os">os</form:option>
		</form:select>

		<form:input path="author" />

	</form:form>

</body>
</html>