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
					
					<form action="profession/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="PROFESSION_ID" id="PROFESSION_ID" value="${pd.PROFESSION_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">专业名称:</td>
								<td><input type="text" name="name" id="name" value="${pd.name}" maxlength="255" placeholder="这里输入专业名称" title="专业名称" style="width:98%;"/></td>
							</tr>
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
								<td style="width:75px;text-align: right;padding-top: 13px;">主干课程:</td>
								<td><textarea type="text" name="course" id="course" value="${pd.course}" maxlength="255" placeholder="这里输入主干课程" title="主干课程" style="width:98%;">${pd.course}</textarea></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">证书:</td>
								<td><input type="text" name="credential" id="credential" value="${pd.credential}" maxlength="255" placeholder="这里输入证书" title="证书" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">就业方向:</td>
								<td><textarea type="text" name="work" id="work" value="${pd.work}" maxlength="255" placeholder="这里输入就业方向" title="就业方向" style="width:98%;">${pd.work}</textarea></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">排序:</td>
								<td><input type="number" name="sort" id="sort" value="${empty pd.sort?1:pd.sort}"   placeholder="这里输入数字" title="排序" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">创建时间:</td>
								<input name="crtime" value="<fmt:formatDate value="${pd.crtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" type="hidden"/>
								<td><fmt:formatDate value="${pd.crtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
		            msg:'请输入所属院系',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#refid").focus();
			return false;
			}
			if($("#name").val()==""){
				$("#name").tips({
					side:3,
		            msg:'请输入专业名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#name").focus();
			return false;
			}
			if($("#course").val()==""){
				$("#course").tips({
					side:3,
		            msg:'请输入主干课程',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#course").focus();
			return false;
			}
			if($("#credential").val()==""){
				$("#credential").tips({
					side:3,
		            msg:'请输入证书',
		            bg:'#AE81FF',
		            time:2
		        });
				$("# credential").focus();
			return false;
			}
			if($("#work").val()==""){
				$("#work").tips({
					side:3,
		            msg:'请输入就业方向',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#work").focus();
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