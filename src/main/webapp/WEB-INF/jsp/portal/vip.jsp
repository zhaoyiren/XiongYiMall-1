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
       <a href="vip.html" class="vipCur">个人中心</a>
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
        <a href="message.html">在线留言</a>
       </dd>
      
      
    </dl><!--helpNav/-->
   </div><!--contLeft/-->
   <div class="contRight">
    <h1 class="vipName"><span>用户名：</span>纯小绿先森  <strong class="vipUp">[点击修改/补充个人信息]</strong></h1>
    <table class="vipMy">
     <tr>
      <th>用户名</th>
      <th>邮编</th>
      <th>真实姓名</th>
      <th>联系方式</th>
      <th>证件号码</th>
      <th>地址</th>
     </tr>
     <tr>
      <td>纯小绿先森</td>
      <td>200000</td>
      <td>张益达</td>
      <td>13322256586</td>
      <td>3124199901235468</td>
      <td>上海市普陀区中友大厦1040弄19楼</td>
     </tr>
    </table><!--vipMy/-->
    <div class="address">
    <div class="addList">
     <label><span class="red">* </span>用户名:</label>
     <input type="text" />
    </div><!--addList-->
    <div class="addList">
     <label><span class="red">* </span>详细地址:</label>
     <input type="text" />
    </div><!--addList-->
    <div class="addList">
     <label><span class="red">* </span>邮政编码:</label>
     <input type="text" />
    </div><!--addList-->
    <div class="addList">
     <label><span class="red">* </span>证件号码:</label>
     <input type="text" />
    </div><!--addList-->
    <div class="addList">
     <label><span class="red">* </span>手机号码:</label>
     <input type="text" /> 或者固定电话 <input type="text" />
    </div><!--addList--> 
    <div class="addList">
     <label><span class="red">* </span>选择地区:</label>
     <select>
      <option>请选择省</option>
     </select>
     <select>
      <option>请选择市</option>
     </select>
     <select>
      <option>请选择地区</option>
     </select>
    </div><!--addList-->
    <div class="addList2">
     <input type="image" src="images/baocun.png" width="79" height="30" />
    </div><!--addList2/-->
   </div><!--address/-->
   </div><!--contRight/-->
   <div class="clears"></div>
  </div><!--cont/-->
  <%@include file="footer.jsp" %><!--footer/-->
 </div><!--mianCont/-->
 <a href="#" class="backTop">&nbsp;</a>
</body>
</html>