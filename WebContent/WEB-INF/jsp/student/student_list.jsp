<%@page pageEncoding="UTF-8" language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="text/javascript" src="../static/js/jquery-1.4.3.js"></script>
        <link href="../static/css/ext-all.css" rel="stylesheet" type="text/css" />
        <script src="../static/js/ext-base.js" type="text/javascript"></script>
        <script src="../static/js/ext-all.js" type="text/javascript"></script>
               
        <title>自制学生信息列表</title>  
        
        <script type="text/javascript">
            function deleteStudent(id){
                if(confirm("是否删除此条信息？"))
                {
                $.ajax({
                    type:'DELETE',
                    url:'/ychen/student/'+id,
                    dataType : 'json',
                    success : function(ok){
                        window.location='/ychen/student/list';
                    }
                    
                });
                }
            }
        </script>
    </head>
    <body>
                   
        <center>
        <!--主要区域开始-->
        <div id="main">            
            <form action="">
                <!-- 数据区域：用表格展示数据 -->
                <div id="data">
                    <input type="button" value="增加" class="btn_add" onclick="location.href='toAdd';"/>
                    <table id="datalist">
                        <tr>
                            <th>id</th>
                            <th>学生姓名</th>
                            <th>年龄</th>
                        </tr>
                        <c:forEach items="${students}" var="student">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.name}</td>
                            <td>${student.age}</td>
                            <td>
                                <input type="button" value="修改" class="btn_modity" onclick="window.location='${student.id}/toUpdate'"/>
                                <input type="button" value="删除" class="btn_delete" onclick="deleteStudent(${student.id});"/>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                    
                </div>
                
            </form>
        </div>
        </center>
    </body>
</html>
