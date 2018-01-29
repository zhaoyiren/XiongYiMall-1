<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>三只松鼠商城</title>
<%@include file="head.jsp" %>
<script type="text/javascript">
 $(function(){
	 $(".vipNav dd:eq(2)").show();
	 })
</script>
</head>

<body>
 <div class="mianCont">
  <%@include file="top.jsp" %>
  <%@include file="hotwordandshopcar.jsp" %>
  <%@include file="category.jsp" %>
   </div><!--pntRight/-->
   <div class="clears"></div>
  </div><!--pnt/-->
  <div class="positions">
   当前位置：<a href="index.html">首页</a> &gt; <a href="vip.html">会员中心</a>
    &gt; <a href="#" class="posCur">我的订单</a>
  </div><!--positions/-->
  <div class="cont">
   <div class="contLeft" id="contLeft">
    <h3 class="leftTitle">会员中心</h3>
    <dl class="helpNav vipNav">
     <dt>我的主页</dt>
      <dd>
       <a href="vip.html">个人中心</a>
       <a href="vipOrder.html">我的订单</a>
      </dd>
     <dt>账户设置</dt>
      <dd>
       <a href="vipMy.html">个人信息</a>
       <a href="vipPwd.html">密码修改</a>
       <a href="vipAdress.html">收货地址</a>
      </dd>
      <dt>客户服务</dt>
       <dd>
        <a href="vipExit.html">网站使用条款</a>
        <a href="vipTuihuo.html">网站免责声明</a>
        <a href="message.html" class="vipCur">在线留言</a>
       </dd>
    </dl><!--helpNav/-->
   </div><!--contLeft/-->
   <div class="contRight">
   <h2 class="oredrName">
    订单详情
   </h2>
   <table class="orderDeatils">
    <tr>
     <th>订单编号</th>
     <td>465489132154416</td>
    </tr>
    <tr>
     <th>商品名称</th>
     <td>妙捷 一次性纸杯</td>
    </tr>
    <tr>
     <th>订单价钱</th>
     <td>￥185.80</td>
    </tr>
    <tr>
     <th>订单信息</th>
     <td> 
张益达，13572607270，， 陕西省 汉中市 勉县 勉县东方眼科医院，724200</td>
    </tr>
    <tr>
     <th>商家</th>
     <td>三只松鼠商城</td>
    </tr>
    <tr>
     <th>支付方式</th>
     <td>支付宝支付</td>
    </tr>
    <tr>
     <th>支付状态</th>
     <td>成功</td>
    </tr>
   </table> 
   </div><!--contRight/-->
   <div class="clears"></div>
  </div><!--cont/-->
  <%@include file="footer.jsp" %><!--footer/-->
 </div><!--mianCont/-->
 <a href="#" class="backTop">&nbsp;</a>
</body>
</html>