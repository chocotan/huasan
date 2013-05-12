<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/c" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<fmt:setBundle basename="io.loli.blog.huasan.prop.all"/>
<jsp:include page="../head.jsp"></jsp:include>
<div class="main">
<div class="posts">
<div class="post" id="${post.id}">
<div class="post-title"><h2><a href="${post.id}.html"><c:out value="${post.title}"></c:out></a></h2></div>
<div class="post-data">
	<span class="post-author"><c:out value="${post.author_name}"></c:out><fmt:message key="post.author"></fmt:message></span>
	<span class="post-date"><fmt:formatDate value="${post.pubDate}" pattern="yyyy-MM-dd"/></span>
	<span class="post-comment-count"><fmt:message key="post.commentcount"></fmt:message><c:out value="${post.commentCount}"></c:out></span>
</div>
<div class="post-content"><c:out value="${post.content}" escapeXml="false"></c:out></div>
</div>
</div>
<c:import url="/comment/list">
<c:param name="p_id"><c:out value="${param.id}"></c:out></c:param>
</c:import>
</div>

<jsp:include page="../foot.jsp"></jsp:include>