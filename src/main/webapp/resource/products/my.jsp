<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page  isELIgnored="false"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

</head>
<body>
<div id="my">
    <h1></h1>

</div>

<script>
    $(function () {
        $.ajax({
            url:"getMy",
            type:"post",
            success:function (data) {

            }
        })
    })
</script>

</body>
</html>
