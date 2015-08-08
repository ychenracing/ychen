<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table id="datalist">
				<tr>
					<td>标题</td>
					<td>${article.title}</td>
				</tr>
				<tr>
					<td>分类</td>
					<td>${article.category}</td>
				</tr>
				<tr>
					<td>作者</td>
					<td>${article.author}</td>
				</tr>
				<tr>
					<td>创建时间</td>
					<td>${article.gmtCreate}</td>
				</tr>
				<tr>
					<td>最后修改时间</td>
					<td>${article.gmtModify}</td>
				</tr>
				<tr>
					<td>内容</td>
					<td>${article.mainBody}</td>
				</tr>
		</table>
</body>
</html>