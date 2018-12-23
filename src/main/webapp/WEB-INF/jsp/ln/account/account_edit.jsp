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
					
					<form action="account/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="accountid" id="accountid" value="${pd.accountid}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">上级院系:</td>
								<td><input type="text" name="refid" id="refid" value="${pd.refid}" maxlength="36" placeholder="这里输入上级院系" title="上级院系" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">0顶级,1非顶级:</td>
								<td><input type="number" name="reftype" id="reftype" value="${pd.reftype}" maxlength="32" placeholder="这里输入0顶级,1非顶级" title="0顶级,1非顶级" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">昵称:</td>
								<td><input type="text" name="nick_name" id="nick_name" value="${pd.nick_name}" maxlength="255" placeholder="这里输入昵称" title="昵称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">性别:</td>
								<td><input type="number" name="gender" id="gender" value="${pd.gender}" maxlength="32" placeholder="这里输入性别" title="性别" style="width:98%;"/></td>
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
								<td><input type="number" name=" state" id=" state" value="${pd. state}" maxlength="32" placeholder="这里输入状态" title="状态" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">城市:</td>
								<td><input type="text" name="city" id="city" value="${pd.city}" maxlength="60" placeholder="这里输入城市" title="城市" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">省份:</td>
								<td><input type="text" name="province" id="province" value="${pd.province}" maxlength="60" placeholder="这里输入省份" title="省份" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">县:</td>
								<td><input type="text" name="country" id="country" value="${pd.country}" maxlength="60" placeholder="这里输入县" title="县" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">头像:</td>
								<td><input type="text" name="avatar_url" id="avatar_url" value="${pd.avatar_url}" maxlength="255" placeholder="这里输入头像" title="头像" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">微信id:</td>
								<td><input type="text" name="open_id" id="open_id" value="${pd.open_id}" maxlength="255" placeholder="这里输入微信id" title="微信id" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">union:</td>
								<td><input type="text" name="union_id" id="union_id" value="${pd.union_id}" maxlength="255" placeholder="这里输入union" title="union" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">电话:</td>
								<td><input type="text" name="phone" id="phone" value="${pd.phone}" maxlength="255" placeholder="这里输入电话" title="电话" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">凭证:</td>
								<td><input type="text" name="token" id="token" value="${pd.token}" maxlength="255" placeholder="这里输入凭证" title="凭证" style="width:98%;"/></td>
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
			if($("#nick_name").val()==""){
				$("#nick_name").tips({
					side:3,
		            msg:'请输入昵称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#nick_name").focus();
			return false;
			}
			if($("#gender").val()==""){
				$("#gender").tips({
					side:3,
		            msg:'请输入性别',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#gender").focus();
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
			if($("# state").val()==""){
				$("# state").tips({
					side:3,
		            msg:'请输入状态',
		            bg:'#AE81FF',
		            time:2
		        });
				$("# state").focus();
			return false;
			}
			if($("#city").val()==""){
				$("#city").tips({
					side:3,
		            msg:'请输入城市',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#city").focus();
			return false;
			}
			if($("#province").val()==""){
				$("#province").tips({
					side:3,
		            msg:'请输入省份',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#province").focus();
			return false;
			}
			if($("#country").val()==""){
				$("#country").tips({
					side:3,
		            msg:'请输入县',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#country").focus();
			return false;
			}
			if($("#avatar_url").val()==""){
				$("#avatar_url").tips({
					side:3,
		            msg:'请输入头像',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#avatar_url").focus();
			return false;
			}
			if($("#open_id").val()==""){
				$("#open_id").tips({
					side:3,
		            msg:'请输入微信id',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#open_id").focus();
			return false;
			}
			if($("#union_id").val()==""){
				$("#union_id").tips({
					side:3,
		            msg:'请输入union',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#union_id").focus();
			return false;
			}
			if($("#phone").val()==""){
				$("#phone").tips({
					side:3,
		            msg:'请输入电话',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#phone").focus();
			return false;
			}
			if($("#token").val()==""){
				$("#token").tips({
					side:3,
		            msg:'请输入凭证',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#token").focus();
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