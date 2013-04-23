<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:setBundle basename="io.loli.blog.huasan.prop.all"/>
<title><fmt:message key="admin.login.title"></fmt:message></title>
</head>
<body>
<form:form method="post" modelAttribute="admin">
<form:errors path="*" cssClass="error"></form:errors>
<table>
	<tr>
		<td><fmt:message key="admin.login.form.name"></fmt:message></td>
		<td><form:input path="name"/></td>
		<td><form:errors path="name" cssClass="error"></form:errors></td>
	</tr>
	<tr>
		<td><fmt:message key="admin.login.form.password"></fmt:message></td>
		<td><form:password path="password"/></td>
		<td><form:errors path="password" cssClass="error"></form:errors></td>
	</tr>
	<tr>
		<td colspan="3"><input type="submit" value="<fmt:message key="admin.login.form.submit"/>"/></td>
	</tr>
</table>
</form:form>
</body>
</html>