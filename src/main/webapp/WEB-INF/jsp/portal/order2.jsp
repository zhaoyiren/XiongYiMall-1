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
   当前位置：<a href="index.html">首页</a> &gt; <a href="#" class="posCur">填写核对订单</a>
  </div><!--positions/-->
  <div class="cont">
   <div class="carImg"><img src="images/car2.jpg" width="961" height="27" /></div>
   <h4 class="orderTitle">收货地址</h4>
   <table class="ord">
    <tr>
     <td width="30%">
      <input type="radio" /> 张大炮
     </td>
     <td width="50%">
      上海,上海市,普陀区,曹杨路1040弄中友大厦一号楼19楼	,200000,13020129519
     </td>
     <td>
      <span class="green upd">[修改]</span> | <span class="green add">[添加]</span> 
     </td>
    </tr>
   </table><!--ord/-->
   <div class="address">
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
    <div class="addList">
     <label><span class="red">* </span>详细地址:</label>
     <input type="text" />
    </div><!--addList-->
    <div class="addList">
     <label><span class="red">* </span>邮政编码:</label>
     <input type="text" />
    </div><!--addList-->
    <div class="addList">
     <label><span class="red">* </span>收件人:</label>
     <input type="text" />
    </div><!--addList-->
    <div class="addList">
     <label><span class="red">* </span>手机号码:</label>
     <input type="text" /> 或者固定电话 <input type="text" />
    </div><!--addList--> 
    <div class="addList2">
     <input type="image" src="images/queren.jpg" width="100" height="32" />
    </div><!--addList2/-->
   </div><!--address/-->
   <h4 class="orderTitle">支付方式</h4>
   <ul class="zhiList">
   <li>网银支付-借记卡</li>
   <li>网银支付-信用卡</li>
   <li>财付通-余额支付</li>
   <li>支付宝-余额支付</li>
   <div class="clears"></div>
  </ul><!--zhiList/-->
  <div class="zhifufangshi">
   <ul class="yinhang">
    <li><input type="radio" /><img src="images/yin1.gif" /></li>
    <li><input type="radio" /><img src="images/yin2.gif" /></li>
    <li><input type="radio" /><img src="images/yin3.gif" /></li>
    <li><input type="radio" /><img src="images/yin4.gif" /></li>
    <li><input type="radio" /><img src="images/yin5.gif" /></li>
    <li><input type="radio" /><img src="images/yin6.gif" /></li>
    <li><input type="radio" /><img src="images/yin7.gif" /></li>
    <li><input type="radio" /><img src="images/yin8.gif" /></li>
    <li><input type="radio" /><img src="images/yin9.gif" /></li>
    <li><input type="radio" /><img src="images/yin1.gif" /></li>
    <li><input type="radio" /><img src="images/yin2.gif" /></li>
    <li><input type="radio" /><img src="images/yin3.gif" /></li>
    <li><input type="radio" /><img src="images/yin4.gif" /></li>
    <li><input type="radio" /><img src="images/yin5.gif" /></li>
    <li><input type="radio" /><img src="images/yin6.gif" /></li>
    <li><input type="radio" /><img src="images/yin7.gif" /></li>
    <li><input type="radio" /><img src="images/yin8.gif" /></li>
    <div class="clears"></div>
   </ul>
  </div><!--zhzhifufangshii/-->
  <div class="zhifufangshi">
   <ul class="yinhang">
    <li><input type="radio" /><img src="images/yin7.gif" /></li>
    <li><input type="radio" /><img src="images/yin8.gif" /></li>
    <li><input type="radio" /><img src="images/yin9.gif" /></li>
    <li><input type="radio" /><img src="images/yin1.gif" /></li>
    <li><input type="radio" /><img src="images/yin2.gif" /></li>
    <li><input type="radio" /><img src="images/yin3.gif" /></li>
    <li><input type="radio" /><img src="images/yin4.gif" /></li>
    <li><input type="radio" /><img src="images/yin5.gif" /></li>
    <li><input type="radio" /><img src="images/yin6.gif" /></li>
    <li><input type="radio" /><img src="images/yin7.gif" /></li>
    <li><input type="radio" /><img src="images/yin8.gif" /></li>
    <div class="clears"></div>
   </ul>
  </div><!--zhzhifufangshii/-->
  <div class="zhifufangshi">
   <ul class="yinhang">
    <li><input type="radio" /><img src="images/caifutong.jpg" /></li>
    <div class="clear"></div>
   </ul>
  </div><!--zhzhifufangshii/-->
  <div class="zhifufangshi">
   <ul class="yinhang">
    <li><input type="radio" /><img src="images/zhifubao.jpg" /></li>
    <div class="clear"></div>
   </ul>
  </div><!--zhzhifufangshii/-->
  <h4 class="orderTitle">购物清单</h4>
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
   <table class="zongjia" align="right">
    <tr>
     <td width="120" align="left">商品总价：</td>
     <td width="60"><strong class="red">+7.88</strong></td>
    </tr>
    <tr>
     <td width="120" align="left">运费总额：</td>
     <td><strong class="red">+121.88</strong></td>
    </tr>
    <tr>
     <td width="120" align="left">促销优惠：</td>
     <td><strong class="red">+341.88</strong></td>
    </tr>
    <tr>
     <td width="120" align="left">合计：</td>
     <td><strong class="red">+2271.88</strong></td>
    </tr>
    <tr>
     <td colspan="2" style="height:50px;">
      <a href="success.html"><img src="images/tijao.png" width="142" height="32" /></a>
     </td>
    </tr>
   </table><!--zongjia/-->
   <div class="clears"></div>
  <%@include file="footer.jsp" %><!--footer/-->
 </div><!--mianCont/-->
 <a href="#" class="backTop">&nbsp;</a>
</body>
</html>
