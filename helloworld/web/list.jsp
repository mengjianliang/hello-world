<%--
  Created by IntelliJ IDEA.
  User: jianliang.meng
  Date: 2016/11/8
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                $.post("json.do",function (data) {
                    var html = "";
                    for(var i=0;i<data.length;i++){
                        html += "<tr><td>"+data[i].id+"</td><td>"+data[i].name+"</td><td>"+data[i].password+"</td></tr>";
                    }
                    $("#html").html(html);
                });
            });

        });
        function updateUserInfo(id) {
            var name = $("#name_"+id).val();
            var password = $("#password_"+id).val();
            alert(name);
            $.post("update.do",{'id':id,'name':name,'password':password},function (data) {
                alert(data);
            });
        }

    </script>
</head>
<body>
    <table width="80%" align="center">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>密码</td>
        </tr>
        <c:forEach items="${list}" var="bean">
            <tr>
                <td>${bean.id}</td>
                <td>${bean.name}</td>
                <td>${bean.password}</td>
                <td><input type="text" id="name_${bean.id}"/></td>
                <td><input type="text" id="password_${bean.id}"/></td>
                <td><a onClick="updateUserInfo(${bean.id})">修改</a></td>
                <td><a href="delete.do?id=${bean.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
