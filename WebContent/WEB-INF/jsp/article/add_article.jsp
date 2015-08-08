<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../static/css/bootstrap.css">
<link rel="stylesheet" href="../static/font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../static/css/simplemde.min.css">
<script src="../static/js/jquery-2.1.1.js"></script>
<script src="../static/js/bootstrap.js"></script>
<script src="../static/js/simplemde.min.js"></script>
<title>创建文章</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<h3>创建文章</h3>
		</div>
	</div>
	
	<form:form action="/ychen/article/addArticle" method="post"
		commandName="articleForm" class="form-horizontal">
		<form:hidden path="id" />

		<div class="form-group">
			<label for="titlePrompt" class="col-sm-1 col-md-1 control-label">标题</label>
			<div class="col-sm-11 col-md-11">
				<form:input path="title" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="mainBodyPrompt" class="col-sm-1 col-md-1 control-label">正文</label>
			<div class="col-sm-11 col-md-11">
				<form:textarea path="mainBody" cssClass="form-control" cols="80" rows="20" />
			</div>
		</div>

		<div class="form-group">
			<label for="categoryPrompt" class="col-sm-1 col-md-1 control-label">分类</label>
			<div class="col-sm-11 col-md-11">
				<form:select path="category" cssClass="form-control">
					<form:option value="select">select please</form:option>
					<form:option value="java">java</form:option>
					<form:option value="spring">spring</form:option>
					<form:option value="db">db</form:option>
					<form:option value="ds">ds</form:option>
					<form:option value="os">os</form:option>
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<label for="authorPrompt" class="col-sm-1 col-md-1 control-label">作者</label>
			<div class="col-sm-11 col-md-11">
				<form:input path="author" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-offset-1 col-sm-4 col-md-4">
				<input type="submit" class="form-control btn btn-primary" value="提交" />
			</div>
			<div class="col-sm-4 col-md-4">
				<input type="button" class="form-control btn btn-danger" value="取消" />
			</div>
		</div>

	</form:form>
	<script>
		var simplemde = new SimpleMDE({
			element : document.getElementById("mainBody")
		});
		simplemde.render();
	</script>
</body>
</html>