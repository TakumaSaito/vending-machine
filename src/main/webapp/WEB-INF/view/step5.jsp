<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>自動販売機ステップ１</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/vending-machine.css" rel="stylesheet">
<script src="js/jquery-2.2.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
<jsp:include page="header.jsp" />

<div class="container">
  <div class="row margin-top-40">
    <div class="col-md-1"></div>
    <div class="col-md-2">
      <h2>お金</h2>
      <ul class="list-group" style="font-size:20px;">
        <li class="list-group-item">10円</li>
        <li class="list-group-item">50円</li>
        <li class="list-group-item">100円</li>
        <li class="list-group-item">500円</li>
        <li class="list-group-item">1000円</li>
      </ul>
    </div>
    <div class="col-md-1"></div>
    <div class="col-md-5">
      <h2>自動販売機</h2>
      <div style="position: relative;">
        <!-- 購入ボタン -->
        <canvas id="vending-machine" width="400" height="500" style="background-color:#337AB7;">
        </canvas>

        <!-- 商品 -->
        <div style="position: absolute; top: 20px; left: 50px;">
          <canvas id="goods-display" width="300" height="100" style="background-color:white;">
          </canvas>
        </div>
        <div style="position: absolute; top: 30px; left: 75px;">
          <canvas id="coke" width="50" height="75" class="coke">
          </canvas>
        </div>
        <div style="position: absolute; top: 30px; left: 170px;">
          <canvas id="red-bull" width="50" height="75" class="red-bull">
          </canvas>
        </div>
        <div style="position: absolute; top: 30px; left: 270px;">
          <canvas id="water" width="50" height="75" class="water">
          </canvas>
        </div>

        <!-- 購入ボタン -->
        <div style="position: absolute; top: 135px; left: 75px;">
          <canvas id="coke-purchase"  class="purchase-button">
          </canvas>
        </div>
        <div style="position: absolute; top: 135px; left: 170px;">
          <canvas id="red-bull-purchase"  class="purchase-button">
          </canvas>
        </div>
        <div style="position: absolute; top: 135px; left: 270px;">
          <canvas id="water-purchase" class="purchase-button">
          </canvas>
        </div>

        <!-- 投入金額 -->
        <div style="position: absolute; top: 175px; left: 250px;">
          <div style="position: relative;">
            <canvas id="display-money" width="120" height="80" style="background-color:black;">
            </canvas>
            <div class="white" style="position: absolute; top: 8px; left: 20px; font-size:20px;">
              投入金額
            </div>
            <div class="white" style="position: absolute; top: 40px; left: 20px; font-size:20px;">
              ￥ <span id="sum-money" >1000</span>
            </div>
          </div>
        </div>

        <!-- 払い戻しボタン -->
        <div style="position: absolute; top: 280px; left: 260px;">
          <div style="position: relative;" class="cursor-pointer">
            <canvas id="return-money" width="120" height="50" style="background-color:#D2D1D1;" class="return-button">
            </canvas>
            <div style="position: absolute; top: 12px; left: 20px; font-size:16px;">
              払い戻し
            </div>
          </div>
        </div>

        <!-- お釣り -->
        <div style="position: absolute; top: 350px; left: 250px;">
          <div style="position: relative;">
            <canvas id="change" width="120" height="80" style="background-color:#D2D1D1;">
            </canvas>
            <div style="position: absolute; top: 8px; left: 20px; font-size:20px;">
              お釣り
            </div>
            <div style="position: absolute; top: 40px; left: 20px; font-size:20px;">
              ￥ <span id="change-money" >0</span>
            </div>
          </div>
        </div>

        <!-- 商品が出てくるところ -->
        <div style="position: absolute; top: 450px; left: 50px;">
          <canvas id="goods-out" width="300" height="30" style="background-color:#9E9E9E;">
          </canvas>
        </div>
      </div>
    </div>
    <div class="col-md-2">
      <h2>在庫</h2>
      <ul class="list-group" style="font-size:20px;">
        <li class="list-group-item coke">コーラ<span id="cokeNum" class="pull-right">5</span></li>
        <li class="list-group-item red-bull">レッドブル<span id="redbullNum" class="pull-right">3</span></li>
        <li class="list-group-item water">水<span id="waterNum" class="pull-right">2</span></li>
      </ul>
    </div>
    <div class="col-md-1"></div>
  </div>
</div>
</body>
<script>
</script>
</html>