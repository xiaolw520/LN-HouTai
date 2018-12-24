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
					
					<form action="enroll/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="enrollid" id="enrollid" value="${pd.enrollid}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">

							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">姓名:</td>
								<td>${pd.real_name}
									<%--<input type="text" name="real_name" id="real_name" value="${pd.real_name}" maxlength="255" placeholder="这里输入姓名" title="姓名" style="width:98%;"/>--%>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">手机号:</td>
								<td>${pd.phone}
									<%--<input type="text" name="phone" id="phone" value="${pd.phone}" maxlength="15" placeholder="这里输入手机号" title="手机号" style="width:98%;"/>--%>
								</td>
							</tr>

							<%--<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">院系id:</td>
								<td><input type="text" name="deptid" id="deptid" value="${pd.deptid}" maxlength="36" placeholder="这里输入院系id" title="院系id" style="width:98%;"/></td>
							</tr>--%>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">学院名称:</td>
								<td>${pd.dept_name}
									<%--<input type="text" name="dept_name" id="dept_name" value="${pd.dept_name}" maxlength="36" placeholder="这里输入学院名称" title="学院名称" style="width:98%;"/>--%>
								</td>
							</tr>
							<%--<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">专业id:</td>
								<td><input type="text" name="professionid" id="professionid" value="${pd.professionid}" maxlength="36" placeholder="这里输入专业id" title="专业id" style="width:98%;"/></td>
							</tr>--%>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">专业名称:</td>
								<td>${pd.profession_name}
									<%--<input type="text" name="profession_name" id="profession_name" value="${pd.profession_name}" maxlength="255" placeholder="这里输入专业名称" title="专业名称" style="width:98%;"/>--%>
								</td>
							</tr>

							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">地址:</td>
								<td><textarea type="text" <%--name="address" id="address" value="${pd.address}" --%>readonly="true" maxlength="255" placeholder="这里输入地址" title="地址" style="width:98%;">${pd.address}</textarea></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">审核状态:</td>
								<td>
									<select class="chosen-select form-control" name="audit_state" id="audit_state" data-placeholder="请选择审核状态" style="vertical-align:top;width: 98%;">
										<option value="0" <c:if test="${pd.audit_state==0}">selected </c:if>>审核中</option>
										<option value="1" <c:if test="${pd.audit_state==1}">selected </c:if>>审核通过</option>
										<option value="2" <c:if test="${pd.audit_state==2}">selected </c:if>>审核不通过</option>
									</select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">审核信息:</td>
								<td><textarea type="text" name="audit_info" id="audit_info" value="${pd.audit_info}" maxlength="255" placeholder="这里输入审核信息" title="审核信息" style="width:98%;">${pd.audit_info}</textarea></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">创建时间:</td>
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

			if($("#audit_state").val()==""){
				$("#audit_state").tips({
					side:3,
		            msg:'请输入审核状态',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#audit_state").focus();
			return false;
			}
			if($("#audit_info").val()==""){
				$("#audit_info").tips({
					side:3,
		            msg:'请输入审核信息',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#audit_info").focus();
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