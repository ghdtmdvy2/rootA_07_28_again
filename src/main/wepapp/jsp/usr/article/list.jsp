<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>게시물 목록</h1>
<%@ include file="../common/head.jsp"%>
<c:forEach items="${articles}" var="article" >
    <span>${article.id}. 제목 : ${article.title} 내용 : ${article.body}</span>
    <a href="/usr/article/delete/free/${article.id}">삭제</a><a href="/usr/article/modify/free/${article.id}">수정</a><br>
</c:forEach>
<%@ include file="../common/foot.jsp"%>
