<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/c" prefix="c" %>
<html>
<head>
<title>
<fmt:setBundle basename="io.loli.blog.huasan.prop.all"/>
<fmt:message key="blog.title"></fmt:message>
</title>
<link rel="stylesheet" type="text/css" href="./css/styles.css" />
</head>
<body>
<div class="head">
	<!-- 这是管理员的头像，请在all.properties中修改 -->
	<div class="headimg">
		<a href="index"><c:import url="/headimg"><c:param name="email"><fmt:message key="admin.email"></fmt:message></c:param></c:import></a>
	</div>
	<div class="menu">
		<ul>
			<li><a href="index">首页</a></li>
		</ul>
	</div>
	<!-- 
	<div class="hitokoto">
		<div class="hi"><c:import url="http://loli.io/hitokoto.jsp"></c:import></div>
	</div>
	 -->
</div>