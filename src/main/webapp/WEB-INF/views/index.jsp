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
		<title>房产信息查询系统</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>resources/plugin/bootstrap-3.3.7-dist/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>resources/plugin/sweet-alert/css/sweet-alert.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>resources/plugin/Flat-UI-master/dist/css/flat-ui.css"/>
		<script src="<%=basePath %>resources/js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath %>resources/plugin/sweet-alert/js/sweet-alert.min.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<div class="container">
			<div class="text-center">
				<h2>房产信息查询系统</h2>
			</div>
			<div style="margin-bottom: 25px;">
				<div>用户名：<span>${user.name }</span>
					<a id="logout" href="javascript:;">退出 </a>
				</div>
			</div>

			<div class="row">
				<div class="col-md-2">
					<a href="javascript:;" id="search">房产信息查询</a>
				</div>
				<div class="col-md-10">
					<div class="panel panel-default">
						<div class="panel-body" id="table_content">
							<div style="padding: 150px 100px 150px 100px;text-align: center;">
								<span style="font-size: 25px; font-weight: bold;">欢迎使用房产信息查询系统</span>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</body>
	<script type="text/javascript">
		$(function(){
			$('#search').on('click',function(){
				var _type = $('#type').val();
				var _value = $('#value').val();
				var date = {
						type: $('#type').val(),
						value:$('#value').val()
						}
				// 清除欢迎语句
				//$('#table_content').html('');
				$('#table_content').load("${pageContext.request.contextPath}/search",date);
				
			});
			$('#logout').on('click',logout);
			
		});
		
		function logout(){
			swal({
				  title: "确定要退出系统吗?",
				  type: "info",
				  showCancelButton: true,
				  confirmButtonColor: "#55C7D7",
				  confirmButtonText: "确定",
				  cancelButtonText: "取消",
				  closeOnConfirm: false
				},
				function(){
					window.location.href = "${pageContext.request.contextPath}/logout";
				});
		}
	</script>
</html>