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
					
					<form action="goods/${msg }.do" name="Form" id="Form" method="post" enctype="multipart/form-data">
						<input type="hidden" name="GOODS_ID" id="GOODS_ID" value="${pd.GOODS_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:50px;text-align: right;padding-top: 13px;">商品名称:</td>
								<td><input type="text" name="GOODSNAME" id="GOODSNAME" value="${pd.GOODSNAME}" maxlength="100" placeholder="这里输入商品名称" title="商品名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:50px;text-align: right;padding-top: 13px;">商品编号:</td>
								<td><input type="text" name="GOODSCODE" id="GOODSCODE" value="${pd.GOODSCODE}" maxlength="32" placeholder="这里输入商品编号" title="商品编号" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:50px;text-align: right;padding-top: 13px;">商品类型:</td>
								<td>
									<select class="chosen-select form-control" name="GOODSTYPE" id="GOODSTYPE" data-placeholder="商品类型" style="vertical-align:top;width: 310px;">
									<c:forEach items="${goodsTypeList}" var="goodsType">
										<option value="${goodsType.DICTIONARIES_ID }" <c:if test="${pd.GOODSTYPE==goodsType.DICTIONARIES_ID}">selected</c:if>>${goodsType.NAME }</option>
									</c:forEach>
								 </select>
								</td>
							</tr>
							<tr>
								<td style="width:50px;text-align: right;padding-top: 13px;">商品封面图:</td>
								<td>
									<c:if test="${pd == null || pd.GOODSPICTURE == '' || pd.GOODSPICTURE == null }">
											<input type="file" id="tp" name="tp" onchange="fileType(this)"/>
									</c:if>
									<c:if test="${pd != null && pd.GOODSPICTURE != '' && pd.GOODSPICTURE != null }">
										<a href="<%=basePath%>uploadFiles/uploadImgs/${pd.GOODSPICTURE}" target="_blank"><img src="<%=basePath%>uploadFiles/uploadImgs/${pd.GOODSPICTURE}" width="210"/></a>
										<input type="button" class="btn btn-mini btn-danger" value="删除" onclick="delP('${pd.GOODSPICTURE}','${pd.GOODS_ID}');" />
										<input type="hidden" name="tpz" id="tpz" value="${pd.GOODSPICTURE }"/>
									</c:if>
								</td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="2">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
								</td>
							</tr>
						</table>
						</div>
						<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
					</form>
	
					<div id="zhongxin2" class="center" style="display:none"><img src="static/images/jzx.gif" style="width: 50px;" /><br/><h4 class="lighter block green"></h4></div>
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
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- 上传控件 -->
	<script src="static/ace/js/ace/elements.fileinput.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript">
		$(top.hangge());
		$(function() {
			//上传
			$('#tp').ace_file_input({
				no_file:'请选择图片 ...',
				btn_choose:'选择',
				btn_change:'更改',
				droppable:false,
				onchange:null,
				thumbnail:false, //| true | large
				whitelist:'gif|png|jpg|jpeg',
				//blacklist:'gif|png|jpg|jpeg'
				//onchange:''
				//
			});
		});
		//保存
		function save(){
			if($("#GOODSNAME").val()==""){
				$("#GOODSNAME").tips({
					side:3,
		            msg:'请输入商品名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#GOODSNAME").focus();
			return false;
			}
			if($("#GOODSCODE").val()==""){
				$("#GOODSCODE").tips({
					side:3,
		            msg:'请输入商品编号',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#GOODSCODE").focus();
			return false;
			}
			if(typeof($("#tpz").val()) == "undefined"){
				if($("#tp").val()=="" || document.getElementById("tp").files[0] =='请选择图片'){
					
					$("#tp").tips({
						side:3,
			            msg:'请选图片',
			            bg:'#AE81FF',
			            time:3
			        });
					return false;
				}
			}
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		//过滤类型
		function fileType(obj){
			var fileType=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
		    if(fileType != '.gif' && fileType != '.png' && fileType != '.jpg' && fileType != '.jpeg'){
		    	$("#tp").tips({
					side:3,
		            msg:'请上传图片格式的文件',
		            bg:'#AE81FF',
		            time:3
		        });
		    	$("#tp").val('');
		    	document.getElementById("tp").files[0] = '请选择图片';
		    }
		}
		
		//删除图片
		function delP(PATH,GOODS_ID){
			 if(confirm("确定要删除图片？")){
				var url = "goods/deltp.do?GOODSPICTURE="+PATH+"&GOODS_ID="+GOODS_ID;
				$.get(url,function(data){
					if(data=="success"){
						alert("删除成功!");
						document.location.reload();
					}
				});
			} 
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
		</script>
</body>
</html>