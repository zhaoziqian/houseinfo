<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>注册页面</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>resources/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>resources/plugin/sweet-alert/css/sweet-alert.css" />
		<script src="<%=basePath %>resources/js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath %>resources/plugin/sweet-alert/js/sweet-alert.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath %>resources/plugin/jquery-validation-1.16.0/dist/jquery.validate.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<div class="container">
			<div class="panel panel-default" style="width: 600px;margin: 0 auto;">
				<div class="panel-heading text-center" style="font-size: 24px;">账号注册</div>
				<div class="panel-body">
					<form:form class="form-horizontal" id="registerForm" commandName="user">
						<div class="form-group">
							<label for="cardId" class="col-md-3 control-label">身份证号：</label>
							<div class="col-md-9">
								<form:input  path="cardId" cssClass="form-control"  />
								<div class="errorMsg"></div>
							</div>
						</div>
						<div class="form-group">
							<label for="username" class="col-md-3 control-label">用户名：</label>
							<div class="col-md-9">
								<form:input  path="name" cssClass="form-control"  />
								<div class="errorMsg"></div>
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-3 control-label">密码：</label>
							<div class="col-md-9">
								<form:password  path="password" cssClass="form-control" />
								<div class="errorMsg"></div>
							</div>
						</div>
						<div class="form-group">
							<label for="confirmPassword" class="col-md-3 control-label">确认密码：</label>
							<div class="col-md-9">
								<input type="password" class="form-control" name="confirmPassword" id="confirmPassword" value="" />
								<div class="errorMsg"></div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-9">
								<input type="submit" class="btn btn-success btn-sm" value="注册" />
								<a href="" onclick="goback()" class="btn btn-primary btn-sm">返回</a>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>

	</body>
	<script type="text/javascript">
		$(function() {
			// 开启表单验证
			jqueryValid();
			// 给input表单设置焦点
			$('input')[0].focus();
			$('input[type=submit]').click(function(){
					var $input = $('input');
					$input.each(function(){
						console.log($(this));
						});
				});
		});
		
		function goback() {
			window.history.back(-1);
		}
		$.validator.setDefaults({
		    submitHandler: function() {
// 		      alert("提交事件!");

		      swal({
				  title: "SUCCESS",
				  text: "注册成功是否去登陆页面",
				  type: "info",
				  showCancelButton: true,
				  confirmButtonColor: "#55C7D7",
				  confirmButtonText: "Yes , 走着 ！",
				  cancelButtonText: "No, 就不去 。。。",
				  closeOnConfirm: false,
				  closeOnCancel: false
				},
				function(isConfirm){
					if (isConfirm) {
					    window.location.href = "${pageContext.request.contextPath}/login"
					  } 
				});
		      
// 				form.submit;
		    }
		});
		function jqueryValid() {
			$('#registerForm').validate({
				rules: {
					cardId: {
						// 必须输入的字段。
						required: true,
						//codeChar: true,
						minlength: 18,
						maxlength: 18,
						remote: {
							url: "${pageContext.request.contextPath}/cardId.valid", //后台处理程序
							type: "post", //数据发送方式
							dataType: "json", //接受数据格式   
							data: { //要传递的数据
// 								'cardId':$("#cardId").val() // 这么写就不能发送数据
								'cardId':function(){	// 这么写就可以
									console.log($("#cardId").val());
									return $("#cardId").val();
									}
							},
							dataFilter: function(data, type) {
								//判断控制器返回的内容
								var json = JSON.parse(data);
								if (json.valid == "1") {
									return true;
								} else if (json.valid == "0") {
									return false;
								}
							}
						}
					},
					name: {
						required: true,
						//codeChar: true,
						minlength: 3,
						maxlength: 25
					},
					password: {
						required: true,
						//passChar: true,
						minlength: 6
					},
					confirmPassword: {
						required: true,
						//passChar: true,
						minlength: 6,
						equalTo: "#password"
					}
				},
				// 自定义的提示语句
				messages: {
					cardId: {
						required: "请输入身份证号",
						remote: "该身份证号已被注册",
						minlength: "身份证号长度为18",
						maxlength: "身份证号长度为18"
					},
					name: {
						required: "请输入用户名",
						minlength: "用户名最少3个字符",
						maxlength: "用户名长度不能超过25"
					},
					password: {
						required: "请输入密码",
						minlength: "密码最少6位"
					},
					confirmPassword: {
						required: "请输入密码",
						minlength: "密码最少6位",
						equalTo: "两次密码不一致"
					}
				},
				errorPlacement:function(error, element){
					console.log($(element));
					$(element).next().append( error );
				}
			});
		}
	</script>

</html>