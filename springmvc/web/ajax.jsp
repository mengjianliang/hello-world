<%--
  Created by IntelliJ IDEA.
  User: jianliang.meng
  Date: 2016/11/8
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    </script>
</head>
<body>
    <input type="button" value="获取数据" id="btn" />
    <table align="center" width="80%">
        <tbody id="html">


        </tbody>

    </table>

</body>
</html>
