<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>三只松鼠商城</title>
<%@include file="head.jsp" %>
<script type="text/javascript">
 $(function(){
	 $(".vipNav dd:first").show();
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
       <a href="vipOrder.html" class="vipCur">我的订单</a>
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
        <a href="message.html">在线留言</a>
       </dd>
      
      
    </dl><!--helpNav/-->
   </div><!--contLeft/-->
   <div class="contRight">
    <h1 class="vipName"><span>用户名：</span>纯小绿先森</h1>
    <h2 class="oredrName">
    我的订单 <span style="margin-left:40px;">待发货 <span class="red">10</span> </span>
    <span>待收货 <span class="red">15</span></span>
    </h2>
    <table class="vipOrder">
     <tr>
      <td><a href="proinfo.html"><img src="images/rdPro4.jpg" width="60" height="55"></a></td>
      <td>张益达</td>
      <td>￥16.9<br />支付宝支付</td>
      <td>2014年6月23日11:32:三只松鼠</td>
      <td><a href="success.html"><strong>等待付款</strong></a></td>
      <td><a href="orderDetails.html">查看</a></td>
     </tr>
     <tr>
      <td><a href="proinfo.html"><img src="images/rdPro3.jpg" width="60" height="55"></a></td>
      <td>张益达</td>
      <td>￥16.9<br />支付宝支付</td>
      <td>2014年6月23日11:32:三只松鼠</td>
      <td><a href="success.html"><strong>等待付款</strong></a></td>
      <td><a href="orderDetails.html">查看</a></td>
     </tr>
     <tr>
      <td><a href="proinfo.html"><img src="images/rdPro2.jpg" width="60" height="55"></a></td>
      <td>张益达</td>
      <td>￥16.9<br />支付宝支付</td>
      <td>2014年6月23日11:32:三只松鼠</td>
      <td><a href="success.html"><strong>等待付款</strong></a></td>
      <td><a href="orderDetails.html">查看</a></td>
     </tr>
     <tr>
      <td><a href="proinfo.html"><img src="images/rdPro1.jpg" width="60" height="55"></a></td>
      <td>张益达</td>
      <td>￥16.9<br />支付宝支付</td>
      <td>2014年6月23日11:32:三只松鼠</td>
      <td><a href="success.html"><strong>等待付款</strong></a></td>
      <td><a href="orderDetails.html">查看</a></td>
     </tr>
     <tr>
      <td><a href="proinfo.html"><img src="images/rdPro5.jpg" width="60" height="55"></a></td>
      <td>张益达</td>
      <td>￥16.9<br />支付宝支付</td>
      <td>2014年6月23日11:32:三只松鼠</td>
      <td><a href="success.html"><strong>等待付款</strong></a></td>
      <td><a href="orderDetails.html">查看</a></td>
     </tr>
    </table><!--vipOrder/-->
    <br />
    <div class="scott"><span class="disabled"> < </span><span class="current">1</span><a href="#?page=2">2</a><a href="#?page=3">3</a><a href="#?page=4">4</a><a href="#?page=5">5</a><a href="#?page=6">6</a><a href="#?page=7">7</a>...<a href="#?page=199">199</a><a href="#?page=200">200</a><a href="#?page=2"> > </a></div>
    <br />
   </div><!--contRight/-->
   <div class="clears"></div>
  </div><!--cont/-->
  <%@include file="footer.jsp" %><!--footer/-->
 </div><!--mianCont/-->
 <a href="#" class="backTop">&nbsp;</a>
</body>
</html>