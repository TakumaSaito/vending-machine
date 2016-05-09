<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>自動販売機ステップ４</title>
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
      <ul id="moneyList" class="list-group cursor-pointer" style="font-size:20px;">
        <li class="list-group-item gray" data-money="1">1円</li>
        <li class="list-group-item gray" data-money="5">5円</li>
        <li class="list-group-item" data-money="10">10円</li>
        <li class="list-group-item" data-money="50">50円</li>
        <li class="list-group-item" data-money="100">100円</li>
        <li class="list-group-item" data-money="500">500円</li>
        <li class="list-group-item" data-money="1000">1000円</li>
        <li class="list-group-item gray" data-money="2000">2000円</li>
        <li class="list-group-item gray" data-money="5000">5000円</li>
        <li class="list-group-item gray" data-money="10000">10000円</li>
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
          <div style="position: relative; cursor: default;">
            <canvas id="coke" class="coke" width="50" height="75" >
            </canvas>
            <div style="position: absolute; top: 8px; left: 14px; font-size:14px;writing-mode: vertical-rl;">
              コ ー ラ
            </div>
          </div>
        </div>

        <!-- 購入ボタン -->
        <div style="position: absolute; top: 135px; left: 75px;">
          <canvas id="coke-purchase"  class="purchase-button" style="background-color: #9E9E9E;">
          </canvas>
        </div>

        <!-- 投入金額 -->
        <div style="position: absolute; top: 175px; left: 250px;">
          <div style="position: relative;">
            <canvas id="display-money" width="120" height="80" style="background-color:black;">
            </canvas>
            <div class="white" style="position: absolute; top: 8px; left: 5px; font-size:20px;">
              投入金額
            </div>
            <div class="white" style="position: absolute; top: 40px; left: 5px; font-size:20px;">
              ￥ <span id="sum-money" >0</span>
            </div>
          </div>
        </div>

        <!-- 払い戻しボタン -->
        <div style="position: absolute; top: 280px; left: 260px;">
          <div id="return-button" style="position: relative;" class="cursor-pointer">
            <canvas width="120" height="50" style="background-color:#D2D1D1;" class="return-button">
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
            <div style="position: absolute; top: 8px; left: 5px; font-size:20px;">
              お釣り
            </div>
            <div style="position: absolute; top: 40px; left: 5px; font-size:20px;">
              ￥ <span id="change-money" ></span>
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
    <div class="col-md-3">
      <h2>商品情報</h2>
      <div style="font-size:20px;">
        <table class="table table-bordered">
          <thead>
            <tr class="info">
              <th width="33%">商品名</th>
              <th width="33%">値段</th>
              <th width="33%">在庫</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><span id="coke-name" >コーラ</span></td>
              <td><span id="coke-price">120</span>円</td>
              <td><span id="coke-stock">5</span>本</td>
            </tr>
          </tbody>
        </table>
      </div>
      <h2 style="margin-top: 80px;">管理者情報</h2>
      <div style="font-size:20px;">
        <table id="coke-info" class="table table-bordered">
          <tbody>
            <tr>
              <td class="success" width="30%">売上</td>
              <td>￥ <span id="sale-amount">0</span></td>
            </tr>
          </tbody>
        </table>
      </div>
  </div>
</div>
</body>
<script>
$(function(){
  var moneyList = $('#moneyList');
  var sumMoney = $('#sum-money');
  var returnButton = $('#return-button');
  var changeMoney = $('#change-money');
  var guide = $('#guide');
  var saleAmount = $('#sale-amount');
  var cokePurchase = $('#coke-purchase');
  var cokePrice = $('#coke-price');
  var cokeStock = $('#coke-stock');

  moneyList.on('click', 'li', function(){
    var li = $(this);
    var money = li.data('money');
    if(money == 1 || money == 5 || money == 2000 || money == 5000 || money == 10000){
      changeMoney.text(money);
    } else {
      var sum = Number(sumMoney.text()) + Number(money);
      sumMoney.text(sum);
      changeMoney.text('');

      if(sum >= Number(cokePrice.text())){
        if(Number(cokeStock.text()) == 0){
            cokePurchase.attr("style", "background-color:#9E9E9E");
        } else {
          cokePurchase.attr("style", "background-color:#FFA500");
        }
      }
    }
  });

  returnButton.on('click', function(){
    var button = $(this);
    var sum = sumMoney.text();
    sumMoney.text(0);
    changeMoney.text(sum);
    cokePurchase.attr("style", "background-color:#9E9E9E");
  })

  cokePurchase.on('click', function(){
    var button = $(this);
    var insertMoney = Number(sumMoney.text());
    var price = Number(cokePrice.text());
    var stock = Number(cokeStock.text());
    var sale = Number(saleAmount.text());

    if(price > insertMoney || stock <= 0){
      return;
    }
    sumMoney.text(insertMoney - price);
    saleAmount.text(sale + price);
    cokeStock.text(stock - 1);
    // TODO バグを埋め込めそう（境界値）
    if(Number(sumMoney.text()) < Number(cokePrice.text())){
      cokePurchase.attr("style", "background-color:#9E9E9E");
    }
    if(Number(cokeStock.text()) == 0){
      cokePurchase.attr("style", "background-color:#9E9E9E");
    }
  })
});
</script>
</html>