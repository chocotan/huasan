<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/c" prefix="c" %>
<jsp:include page="head.jsp"></jsp:include>
<c:import url="/post/list">
<c:param name="page">
<c:choose>
<c:when test="${param.page>0}">${param.page}</c:when>
<c:otherwise>1</c:otherwise>
</c:choose>
</c:param>
</c:import>
<jsp:include page="foot.jsp"></jsp:include>