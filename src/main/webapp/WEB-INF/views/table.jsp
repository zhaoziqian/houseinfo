<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="text-center"
	style="font-size: 25px; font-weight: bold; margin-bottom: 15px;">房产信息查询</div>
<table class="table table-bordered">

	<div class="text-center" style="margin-bottom: 15px;">

		<form action="" method="post" class="form-inline">
			<div class="form-group col-md-2">
				<p class="form-control-static">查询类型：</p>
			</div>
			<div class="form-group col-md-2">
				<label for="type" class="sr-only">类型</label> 
				<select name="type" id="type" class="form-control">
					<option value="username" <c:if test="${type eq 'username' }">selected</c:if> >用户名</option>
					<option value="cardId" <c:if test="${type eq 'cardId' }">selected</c:if> >身份证</option>
				</select>
			</div>
			<div class="form-group col-md-5">
				<label for="value" class="sr-only">查询内容</label> 
				<input type="text" class="form-control" name="value" id="value" value="${ searchKey}" />
			</div>
			<button type="button" id="searchForm" class="btn btn-success">查&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;询</button>
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
	<c:forEach items="${houseVos}" var="h">
		<tr>
			<td>${h.id}</td>
			<td>${h.projectName }</td>
			<td>${h.name }</td>
			<td>${h.cardId }</td>
			<td>${h.houseType }</td>
			<td>${h.area }</td>
			<td><fmt:formatDate value="${h.buildTime }" pattern="yyyy-MM-dd" />
			</td>
		</tr>
	</c:forEach>
</table>
<nav class="text-center">
	<ul class="pagination">
		<li><a href="javascript:;" data-index="1">首&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
		<li><a href="javascript:;" <c:if test="${prev }"> data-index="${pageIndex - 1 }" </c:if> >&laquo;上一页</a></li>
		<li><a href="javascript:;" <c:if test="${next }"> data-index="${pageIndex + 1 }"</c:if> >下一页&raquo;</a></li>
		<li><a href="javascript:;" data-index="${pageTotal }">尾&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
	</ul>
	<ul style="list-style: none; display: inline-block;">
		<li style="display: inline-block;">第${pageIndex }页</li>
		<li style="display: inline-block;">/</li>
		<li style="display: inline-block;">共${pageTotal }页</li>
		<li style="display: inline-block;">（${total }条）</li>
	</ul>
</nav>
<script type="text/javascript">
	$(function() {
		$('#searchForm').on('click',
				function() {
					var _type = $('#type').val();
					var _value = $('#value').val();
					console.log(_type + "\t" + _value);
					var date = {
						pageSize : '${pageSize }',
						type : $('#type').val(),
						value : $('#value').val()
					}
					$('#table_content').load("${pageContext.request.contextPath}/search", date);
				});
		$('#logout').on('click', logout);

		$(function(){
			$('a[data-index]').on('click',function(){
				
				var date = {
						pageIndex : $(this).data('index'),
						pageSize : '${ pageSize }',
						searchType:$('#type').val(),
						searchKey : $('#value').val()
				}
				$('#content').load('${pageContext.request.contextPath }/search',date);
			});
		});
	});
</script>

