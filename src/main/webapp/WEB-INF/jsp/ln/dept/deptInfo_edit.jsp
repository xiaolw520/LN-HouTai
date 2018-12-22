<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>">
	<!-- 下拉框 -->
	<link rel="stylesheet" href="static/ace/css/chosen.css" />
	<!-- jsp文件头和头部 -->
	<%@ include file="../../system/index/top.jsp"%>
	<!-- 日期框 -->
	<link rel="stylesheet" href="static/ace/css/datepicker.css" />
</head>
<body class="no-skin">
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
	<!-- /section:basics/sidebar -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
					
					<form action="deptinfo/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="deptinfoid" id="deptinfoid" value="${pd.deptinfoid}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">所属院系:</td>
								<td>
									<%--<input type="text" name="refid" id="refid" value="${pd.refid}" maxlength="36" placeholder="这里输入所属院系" title="所属院系" style="width:98%;"/>--%>
									<select class="chosen-select form-control" name="refid" id="refid" data-placeholder="请选择院系" style="vertical-align:top;width:98%;">

										<c:forEach items="${deptNames}" var="var" varStatus="vs">
											<option value="${var.deptid}" <c:if test="${var.deptid==pd.refid}">selected = "selected" </c:if>>${var.name}</option>
										</c:forEach>
									</select>


								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">文字:</td>
								<td><input type="text" name="info" id="info" value="${pd.info}" maxlength="255" placeholder="这里输入文字" title="文字" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">创建时间:</td>
								<td><input class="span10 date-picker" name="crtime" id="crtime" value="${pd.crtime}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="创建时间" title="创建时间" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">更新时间:</td>
								<td><input class="span10 date-picker" name="uptime" id="uptime" value="${pd.uptime}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="更新时间" title="更新时间" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">软删除:</td>
								<td><input type="number" name="isdel" id="isdel" value="${pd.isdel}" maxlength="32" placeholder="这里输入软删除" title="软删除" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">状态:</td>
								<td><input type="number" name="state" id="state" value="${pd.state}" maxlength="32" placeholder="这里输入状态" title="状态" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">排序:</td>
								<td><input type="number" name="sort" id="sort" value="${pd.sort}" maxlength="32" placeholder="这里输入排序" title="排序" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">图片地址:</td>
								<td><input type="text" name="imgUrl" id="imgUrl" value="${pd.imgUrl}" maxlength="255" placeholder="这里输入图片地址" title="图片地址" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
								</td>
							</tr>
						</table>
						</div>
						<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
					</form>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->
</div>
<!-- /.main-container -->


	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript">
		$(top.hangge());
		//保存
		function save(){
			if($("#refid").val()==""){
				$("#refid").tips({
					side:3,
		            msg:'请输入上级院系',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#refid").focus();
			return false;
			}
			if($("#reftype").val()==""){
				$("#reftype").tips({
					side:3,
		            msg:'请输入0顶级,1非顶级',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#reftype").focus();
			return false;
			}
			if($("#info").val()==""){
				$("#info").tips({
					side:3,
		            msg:'请输入文字',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#info").focus();
			return false;
			}
			if($("#crtime").val()==""){
				$("#crtime").tips({
					side:3,
		            msg:'请输入创建时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#crtime").focus();
			return false;
			}
			if($("#uptime").val()==""){
				$("#uptime").tips({
					side:3,
		            msg:'请输入更新时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#uptime").focus();
			return false;
			}
			if($("#isdel").val()==""){
				$("#isdel").tips({
					side:3,
		            msg:'请输入软删除',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#isdel").focus();
			return false;
			}
			if($("#state").val()==""){
				$("#state").tips({
					side:3,
		            msg:'请输入状态',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#state").focus();
			return false;
			}
			if($("#sort").val()==""){
				$("#sort").tips({
					side:3,
		            msg:'请输入排序',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#sort").focus();
			return false;
			}
			if($("#imgUrl").val()==""){
				$("#imgUrl").tips({
					side:3,
		            msg:'请输入图片地址',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#imgUrl").focus();
			return false;
			}
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
		</script>
</body>
</html>