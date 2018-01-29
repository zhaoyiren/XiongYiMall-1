<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>三只松鼠商城</title>
<%@include file="head.jsp" %>
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
   当前位置：<a href="index.html">首页</a> &gt; <a href="#" class="posCur">购物车</a>
  </div><!--positions/-->
  <div class="cont">
   <div class="carImg"><img src="images/car1.jpg" width="951" height="27" /></div>
   <table class="orderList">
    <tr>
     <th width="20"></th>
     <th width="430">商品</th>
     <th width="135">单价</th>
     <th width="135">数量</th>
     <th width="135">总金额</th>
     <th>操作</th>
    </tr>
    <tr>
     <td><input type="checkbox" /></td>
     <td>
      <dl>
       <dt><a href="proinfo.html"><img src="images/pro1.jpg" width="85" height="85" /></a></dt>
       <dd>全球最大的中文搜索引擎、致力于让网民更便捷<br /><span class="red">有货：</span>从上海出发</dd>
       <div class="clears"></div>
      </dl>
     </td>
     <td><strong class="red">￥70.20</strong></td>
     <td>
     <div class="jia_jian">
      <img src="images/jian.jpg" width="21" height="25" class="jian" />
      <input type="text" class="shuliang" value="1" />
      <img src="images/jia.jpg" width="21" height="25" class="jia" />
     </div>
     </td>
     <td><strong class="red">￥70.20</strong></td>
     <td><a href="#" class="green">收藏</a><br /><a href="#" class="green">删除</a></td>
    </tr>
    
    <tr>
     <td colspan="6"><div class="shanchu"><img src="images/lajio.jpg" /> 全部删除</div></td>
    </tr>
   </table><!--orderList/-->
   <div class="zongji">
    总计(不含运费)：<strong class="red">￥70.42</strong>
   </div><!--zongji/-->
   <div class="jiesuan">
    <a href="product.html" class="jie_1">继续购物&gt;&gt;</a>
    <a href="order2.html" class="jie_2">立即结算&gt;&gt;</a>
    <div class="clears"></div>
   </div><!--jiesuan/-->
   <div class="clears"></div>
  </div><!--cont/-->
  <%@include file="footer.jsp" %><!--footer/-->
 </div><!--mianCont/-->
 <a href="#" class="backTop">&nbsp;</a>
</body>
</html>
