<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/c" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="main">
<div class="posts">

<fmt:setBundle basename="io.loli.blog.huasan.prop.all"/>
<c:forEach var="post" items="${postList}">
<div class="post" id="${post.id}">
<div class="post-title"><h2><a href="post?id=${post.id}"><c:out value="${post.title}"></c:out></a></h2></div>
<div class="post-data">
	<span class="post-author"><c:out value="${post.author_name}"></c:out><fmt:message key="post.author"></fmt:message></span>
	<span class="post-date"><fmt:formatDate value="${post.pubDate}" pattern="yyyy-MM-dd"/></span>
	<span class="post-comment-count"><fmt:message key="post.commentcount"></fmt:message><c:out value="${post.commentCount}"></c:out></span>
</div>
<div class="post-content"><c:out value="${post.content}" escapeXml="false"></c:out></div>
</div>
</c:forEach>
</div>
<div class="page">
	<c:if test="${hasLast}"><a href="?page=${param.page-1}"><fmt:message key="last"></fmt:message></a></c:if>
	<c:if test="${hasNext}"><a href="?page=${param.page+1}"><fmt:message key="next"></fmt:message></a></c:if>
</div>
</div>