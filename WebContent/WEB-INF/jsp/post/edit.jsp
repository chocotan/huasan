<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<fmt:setBundle basename="io.loli.blog.huasan.prop.all"/>
<form:form action="/post/edit" modelAttribute="post">
<table>
<tr>
	<td><fmt:message key="admin.add.form.title"></fmt:message></td>
	<td><form:input value="${post.title}" path="title"/></td>
</tr>
<tr>
	<td><fmt:message key="admin.add.form.content"></fmt:message></td>
	<td><form:textarea value="${post.content}" path="content"/></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="<fmt:message key="admin.add.form.submit"/>"></td>
</tr>
</table>
</form:form>