<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>自動販売機</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/vending-machine.css" rel="stylesheet">
<script src="js/jquery-2.2.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
<jsp:include page="header.jsp" />

<div class="container">
  <div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-4">
      <h2>ステップ１</h2>
      <a class="btn btn-default btn-block btn-info section" href="/step1">
        <i class="fa fa-jpy"></i>　お金の投入と払い戻し
      </a>
    </div>
    <div class="col-md-4">
      <h2>ステップ２</h2>
      <a class="btn btn-default btn-block btn-info section" href="/step2">
        <i class="fa fa-money"></i>　扱えないお金
      </a>
    </div>
    <div class="col-md-2"></div>
  </div>

  <div class="row margin-top-40">
    <div class="col-md-2"></div>
    <div class="col-md-4">
      <h2>ステップ３</h2>
      <a class="btn btn-default btn-block btn-warning section" href="/step3">
        <i class="fa fa-database"></i>　ジュースの管理
      </a>
    </div>
    <div class="col-md-4">
      <h2>ステップ４</h2>
      <a class="btn btn-default btn-block btn-warning section" href="/step4">
        <i class="fa fa-hand-o-right"></i>　購入
      </a>
    </div>
    <div class="col-md-2"></div>
  </div>

  <div class="row margin-top-40">
    <div class="col-md-2"></div>
    <div class="col-md-4">
      <h2>ステップ５</h2>
      <a class="btn btn-default btn-block btn-danger section" href="/step5">
        <i class="fa fa-wrench"></i>　機能拡張
      </a>
    </div>
    <div class="col-md-4">
      <h2>ステップ６</h2>
      <a class="btn btn-default btn-block btn-danger section" href="/step6">
        <i class="fa fa-line-chart"></i>　釣り銭と売り上げ管理
      </a>
    </div>
    <div class="col-md-2"></div>
  </div>
</div>
</body>
</html>