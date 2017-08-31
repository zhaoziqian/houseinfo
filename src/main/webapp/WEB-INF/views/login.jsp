<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>登陆页面</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>resources/plugin/bootstrap-3.3.7-dist/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>resources/plugin/sweet-alert/css/sweet-alert.css" />
		<script src="<%=basePath %>resources/js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath %>resources/plugin/sweet-alert/js/sweet-alert.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath %>resources/plugin/jquery-validation-1.16.0/dist/jquery.validate.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<div class="container" >
			<div class="panel panel-default" style="width: 600px;margin: 0 auto;">
				<div class="panel-heading text-center" style="font-size: 24px;">房产信息查询系统</div>
				<div class="panel-body">
					<form class="form-horizontal" id="loginForm">
						<div class="form-group">
							<label for="cardId" class="col-md-3 control-label">请输入身份证号：</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="cardId" id="cardId" value="" />
								<div class="errorMsg"></div>
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-3 control-label">请输入密码：</label>
							<div class="col-md-9">
								<input type="password" class="form-control" name="password" id="password" value="" />
								<div class="errorMsg"></div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-9">
								<input type="submit" class="btn btn-success btn-sm" value="登陆" />
								<a href="javascript:;" id="goReg" class="btn btn-primary btn-sm">注册</a>
							</div>
						</div>
					</form>
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
			$('a#goReg').on('click',goReg);
		});

		function goReg() {
			window.location.href = "${pageContext.request.contextPath}/register";
		}

		// 重写登陆提交方法
		$.validator.setDefaults({
		    submitHandler: function() {
// 		      alert("提交事件!");
				var cardId = $('#cardId').val();
				var password = $('#password').val();
			// 若要实现由提示框选择跳转，那么就需要ajax去注册
			$.post(
					"${pageContext.request.contextPath}/log",
					{
						'cardId':cardId,
						'password':password
					},
					function(data){
						console.log(data);
						if (data.result == "success") {
							window.location.href = "${pageContext.request.contextPath}/index"
						} else {
							swal({
								title: "ERROR",
							    text: data.result,
							    type: "warning"
							})
						}
					},
					"JSON"
			);
// 				form.submit;
		    }
		});
		

		function jqueryValid() {
			$('#loginForm').validate({
				rules: {
					cardId: {
						// 必须输入的字段。
						required: true,
						//codeChar: true,
						minlength: 18,
						maxlength: 18
					},
					password: {
						required: true,
						//passChar: true,
						minlength: 6
					}
				},
				// 自定义的提示语句
				messages: {
					cardId: {
						required: "请输入身份证号",
						minlength: "身份证号长度为18",
						maxlength: "身份证号长度为18"
					},
					password: {
						required: "请输入密码",
						minlength: "密码最少6位"
					}
				},
				errorPlacement: function(error, element) {
					console.log($(element));
					$(element).next().append(error);
				}
			});
		}
	</script>
</html>