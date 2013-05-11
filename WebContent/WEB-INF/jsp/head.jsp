<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/c" prefix="c"%>
<%@ page import="io.loli.util.*" %>
<html>
<head>
<fmt:setBundle basename="io.loli.blog.huasan.prop.all" />
<title><c:choose><c:when test="${requestScope.post==null}"><fmt:message key="blog.title"></fmt:message></c:when><c:otherwise><c:out value="${post.title}"></c:out>-<fmt:message key="blog.title"></fmt:message></c:otherwise></c:choose>
</title>
<link rel="stylesheet" type="text/css" href="./css/styles.css" />
<script src="http://api.hitokoto.us/rand?encode=js"></script>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="icon" href="favicon.ico" />
<meta charset="utf-8" />
<script type="text/javascript" src="./highlight/highlight.js"></script>
<link rel="stylesheet" type="text/css" href="./highlight/github.css">


<script src="./css/jquery-1.9.1.min.js"></script>
<script src="./css/jquery.cookie.js"></script>
<script >
	function reply(id,name) {
		var html = "<a href='"+"#comment-"+id+"'"+">";
		document.getElementById("newCommentContent").focus();
		document.getElementById("newCommentContent").innerHTML = html
				+ "@" + name + "</a>" + " ";
		document.getElementById("reply_id").value = id;
		
	}
	function notspam(obj){
		document.getElementById("spam").value=1;
		saveCookie(obj);
		return true;
	}
	function saveCookie(obj){
		$.removeCookie('nickname');
		$.removeCookie('email');
		$.removeCookie('website');
		$.cookie('nickname',$("input#username").val(),{expires:180 });
		$.cookie('email',$("input#email").val(),{expires:180 });
		$.cookie('website',$("input#website").val(),{expires:180 });
	}
</script>
<script type="text/javascript">
	
</script>
</head>
<body
	style="background-image:url('/img/bg<%=(int) (Math.random() * 3)%>.jpg')">
	<div class="head">
		<!-- 这是管理员的头像，请在all.properties中修改 -->
		<div class="headimg">
			<a href="index"><c:import url="/headimg">
					<c:param name="email">
						<fmt:message key="admin.email"></fmt:message>
					</c:param>
					<c:param name="size">150</c:param>
				</c:import></a>
		</div>
		<div class="menu">
			<ul>
				<li><a href="/">首页</a></li>
				<li><a href="http://about.me/AmahaChoco" target="_blank">关于我</a></li>
				<li><a href="http://loli.lt/" target="_blank">爱花伞</a></li>
				<li><a href="http://stackbox.org/" target="_blank">爱箱娘</a></li>
				<li><a href="./#links">友情链接</a></li>
			</ul>
		</div>
		<div class="info">
			<ul>
				<li><a href="./feed">RSS</a></li>
				<li>请用<a href="https://www.google.com/intl/en/chrome/browser/"
					target="_blank">chrome</a></li>
			</ul>
		</div>
		<div class="alink">
			<div class="content">
				<ul>
					<li>赞助商</li>
					<%=HtmlParser.getHtmlContent("https://raw.github.com/chocotan/io.loli.util/master/src/ad")%>
				</ul>
			</div>
		</div>
		<div id="hitokoto">
			<div class="hi">
				<script type="text/javascript">
					hitokoto();
				</script>
			</div>
		</div>
	</div>