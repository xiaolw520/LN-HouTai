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
		<style type="text/css">
			.yulantu{
				z-index: 9999999999999999;
				position:absolute;
				border:2px solid #76ACCD;
				display: none;
			}
		</style>
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
								<td><textarea type="text" name="info" id="info" value="${pd.info}" maxlength="255" placeholder="这里输入文字" title="文字" style="width:98%;">${pd.info}</textarea></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">图片地址:</td>
								<td><input type="text" name="imgUrl" id="imgUrl" value="${pd.imgUrl}" maxlength="100" placeholder="图片地址" title="图片地址" style="width:86%;" onmouseover="showTU('imgUrl','yulantu');" onmouseout="hideTU('yulantu');"/>
									<div class="yulantu" id="yulantu"></div>
									<a class="btn btn-xs btn-info" style="margin-top: -5px;" title="选择" onclick="xuanTp('imgUrl');">选择 </a>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">排序:</td>
								<td><input type="number" name="sort" id="sort" value="${pd.sort}" maxlength="32" placeholder="这里输入排序" title="排序" style="width:98%;"/></td>
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
		            msg:'请输入上级院系',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#refid").focus();
				return false;
			}

			if($("#info").val()=="" && $("#imgUrl").val()==""){
				$("#info").tips({
					side:3,
		            msg:'请输入文字',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#info").focus();
				return false;
                $("#imgUrl").tips({
                    side:3,
                    msg:'请输入图片地址',
                    bg:'#AE81FF',
                    time:2
                });
                $("#imgUrl").focus();
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

			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
        //选择图片
        function xuanTp(ID){
            top.jzts();
            var diag = new top.Dialog();
            diag.Drag=true;
            diag.Title ="选择图片";
            diag.URL = '<%=basePath%>pictures/listfortc.do';
            diag.Width = 860;
            diag.Height = 680;
            diag.CancelEvent = function(){ //关闭事件
                $("#"+ID).val(diag.innerFrame.contentWindow.document.getElementById('xzvalue').value);
                diag.close();
            };
            diag.show();
        }

        //显示图片
        function showTU(ID,TPID){
            $("#"+TPID).html('<img width="200" src="'+$("#"+ID).val()+'">');
            $("#"+TPID).show();
        }

        //隐藏图片
        function hideTU(TPID){
            $("#"+TPID).hide();
        }
		</script>
</body>
</html>