<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page  isELIgnored="false"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <link rel="stylesheet" href="<%=basePath%>resource/css/login.css" type="text/css" media="all">
<style>
  #msg,#msg2{
    color: white;
  }


</style>



</head>

<body>
<h1>登录注册</h1>
<div class="container w3layouts agileits">
  <div class="login w3layouts agileits">
    <h2>登 录</h2>
   
      <input type="text"      id="username1"  placeholder="用户名" >
      <input type="password"  id="password1" placeholder="密码"   >

	
    <div class="send-button w3layouts agileits">    
        <input type="button" value="登 录" id="btnLogin">
           <div id="msg"></div>
    </div>

	 
	 
    <div class="clear"></div>
	
  </div>
  
  <div class="clear"></div>
</div>

<div class="footer w3layouts agileits">
  <p>Copyright &copy; More Templates</p>
</div>

<input type="hidden" value="<%=basePath%>" id="hidd">
<script type="text/javascript" charset="UTF-8">

  $(function () {
    window.fla;

    /*var flag = getCookie("flag");
    var username = getCookie("username");
    var password = getCookie("password");


    if (flag == "true"){
      $("#username1").val(username);
      $("#password1").val(password);
      $("input[type='checkbox']").attr("checked","checked");
    }else {
      $("#username1").val(username);
      $("#password1").val('');
      $("input[type='checkbox']").removeAttr("checked");
    }*/

    $("#btnLogin").click(function () {
      if($("#username1").val()!=''&&$("#password1").val()!='') {
        $.ajax({
          url: "adlogin",
          type: "post",
          data: {
            "username": $("#username1").val(),
            "password": $("#password1").val(),
          },
          success: function (data) {

            if(data==true) {
              $("#msg").html("登录成功");
              window.location.href="<%=path%>/resource/admin/adminBack.jsp"
            }else {
              $("#msg").html("密码或账号错误");
            }
          }
        })
      }else{
        $("#msg").html("信息不能为空!");
      }
    })
    /*js获取cookie值*/
    function getCookie(name){
      var strcookie = document.cookie;
      var arrcookie = strcookie.split("; ");
      for ( var i = 0; i < arrcookie.length; i++) {
        var arr = arrcookie[i].split("=");
        if (arr[0] == name){
          return arr[1];
        }
      }
      return "";
    }
  })


  
</script>

</body>


</html>
