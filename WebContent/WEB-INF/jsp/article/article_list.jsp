<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章列表</title>
</head>
<body>

	<!-- 数据区域：用表格展示数据 -->
	<div id="data">
		<input type="button" value="增加" class="btn_add"
			onclick="location.href='addArticle';" />
		<table id="datalist">
			<c:forEach items="${articles}" var="article">
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
			</c:forEach>
		</table>
	</div>
	
</body>
</html>