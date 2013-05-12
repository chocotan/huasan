<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/c" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<fmt:setBundle basename="io.loli.blog.huasan.prop.all" />

<div class="comments">
	<ul class="commentListList">
		<c:forEach var="commentList" items="${commentListList}">
			<li>
				<div class="commentList">
					<ul>
						<c:forEach var="comment" items="${commentList}">
							<li
								class="comment <c:choose><c:when test='${comment.reply_id==0}'>father</c:when><c:otherwise>child</c:otherwise></c:choose>"
								id="comment-${comment.id}">
								<div class="commentHead">
									<c:import url="/headimg">
											<c:param name="email">
												<c:out value="${comment.email}"></c:out>
											</c:param>
											<c:param name="size">40</c:param>
										</c:import>
								</div> <span class="commentAuthor"><a href="${comment.website}" target="_blank"><c:out
										value="${comment.username}"></c:out></a></span> <span class="commentDate"><fmt:message key="post.author"></fmt:message> <fmt:formatDate
										value="${comment.pubDate}" pattern="yyyy-MM-dd HH:mm" timeZone="GMT+8"/></span>
								<div class="reply">
									<c:if test="${sessionScope.admin!=null}"><a href="./comment/delete?id=${comment.id}&p_id=${param.id}"><fmt:message key="comment.delete"></fmt:message></a></c:if>
									<a href="#newComment" onclick="reply(${comment.id},'${comment.username}');"><fmt:message key="comment.reply"></fmt:message></a>
								</div>
								<div class="commentContent" id="commentContent">
									<c:out value="${comment.content}" escapeXml="false"></c:out>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</li>
		</c:forEach>
	</ul>
	<div class="newComment" id="newComment">
		<form:form onsubmit="notspam(this);" action="/comment/add" modelAttribute="comment">
		<input type="hidden" name="p_id" value="${param.id}">
		<input type="hidden" id="reply_id" name="reply_id" value="0">
		<input type="hidden" id="spam" name="spam" value="0">
			<table>
				<tr>
					<td><fmt:message key="comment.nickname"></fmt:message></td>
					<td><form:input path="username" /></td>
				</tr>
				<tr>
					<td><fmt:message key="comment.email"></fmt:message></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><fmt:message key="comment.website"></fmt:message></td>
					<td><form:input path="website"/></td>
				</tr>
				
				<tr>
					<td></td>
					<td><form:textarea id="newCommentContent" path="content" cols="50" rows="7" /></td>
				<tr><td></td><td><input type="submit" value="<fmt:message key="admin.add.form.submit"/>"></td></tr>
			</table>
		</form:form>
	</div>
</div>