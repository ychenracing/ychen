<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>学生信息增加</title>
    </head>
    <body>
        <!--主要区域开始-->
        <div id="main">
            <center>
            <form:form action="add.from" method="post" commandName="student">
                <div class="text_info clearfix"><span>ID:</span></div>
                <div class="input_info">
                <form:input path="id"/>
                </div>
                <div class="text_info clearfix"><span>姓名</span></div>
                <div class="input_info">
                <form:input path="name" cssClass="width300"/>
                </div>
                <div class="text_info clearfix"><span>年龄</span></div>
                <div class="input_info">
                <form:input path="age"/>
                </div>
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save"/>
                    <input type="button" value="取消" class="btn_save" onclick="window.location.href='list'"/>
                </div>
            </form:form>
            </center>
        </div>
        <!--主要区域结束-->
        
    </body>
</html>
