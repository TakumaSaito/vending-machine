<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid bg-primary border-bottom-accent">
  <div class="container">
    <h2>
      <a href="/"  class="text-decoration-none white non-hover">
      テストケースの洗い出し
      <c:if test="${!empty step}">
        （<c:out value="${step}" />）
      </c:if>
      </a>
    </h2>
  </div>
</div>
