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
		<link rel="stylesheet" type="text/css" href="<%=basePath %>resources/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
		<script src="<%=basePath %>resources/js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath %>resources/plugin/jquery-validation-1.16.0/dist/jquery.validate.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<div class="container" >
			<div class="panel panel-default" style="width: 600px;margin: 0 auto;">
				<div class="panel-heading text-center" style="font-size: 24px;">房产信息查询系统</div>
				<div class="panel-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="cardId" class="col-md-3 control-label">请输入身份证号：</label>
							<div class="col-md-9">
								<input type="text" class="form-control" id="cardId" value="" />
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-3 control-label">请输入密码：</label>
							<div class="col-md-9">
								<input type="password" class="form-control" id="password" value="" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-9">
								<input type="submit" class="btn btn-success btn-sm" value="登陆" />
								<a href="" class="btn btn-primary btn-sm">注册</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</body>

</html>