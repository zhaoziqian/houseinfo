<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="text-center" style="font-size: 25px; font-weight: bold;margin-bottom: 15px;">房产信息查询</div>
<table class="table table-bordered">
	
	<div class="text-center" style="margin-bottom: 15px;">
		
		<form action="" method="post" class="form-inline">
			<div class="form-group col-md-2">
				<p class="form-control-static">查询类型：</p>
			</div>
			<div class="form-group col-md-2">
				<label for="type" class="sr-only">类型</label>
				<select name="type" class="form-control">
					<option value="username">用户名</option>
					<option value="cardId">身份证</option>
				</select>
			</div>
			<div class="form-group col-md-5">
				<label for="value" class="sr-only">查询内容</label>
				<input type="text" class="form-control" name="value" id="value" value="" />
			</div>
			<button type="button" class="btn btn-success">查&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;询</button>
		</form>
		
	</div>

	<tr class="success">
		<th>序号</th>
		<th>项目名称</th>
		<th>产权人</th>
		<th>身份证号</th>
		<th>房屋类型</th>
		<th>使用面积</th>
		<th>建造时间</th>
	</tr>
	<tr>
		<td>data</td>
		<td>data</td>
		<td>data</td>
		<td>data</td>
		<td>data</td>
		<td>data</td>
		<td>data</td>
	</tr>
	<tr>
		<td>data</td>
		<td>data</td>
		<td>data</td>
		<td>data</td>
		<td>data</td>
		<td>data</td>
		<td>data</td>
	</tr>
</table>
<nav class="text-center">
	<ul class="pagination">
		<li>
			<a href="#">首&nbsp;&nbsp;&nbsp;&nbsp;页</a>
		</li>
		<li>
			<a href="#">&laquo;上一页</a>
		</li>
		<li>
			<a href="#">下一页&raquo;</a>
		</li>
		<li>
			<a href="#">尾&nbsp;&nbsp;&nbsp;&nbsp;页</a>
		</li>
	</ul>
	<ul style="list-style: none;display: inline-block;">
		<li style="display: inline-block;">第1页</li>
		<li style="display: inline-block;"> / </li>
		<li style="display: inline-block;">共12页</li>
		<li style="display: inline-block;">（58条）</li>
	</ul>
</nav>