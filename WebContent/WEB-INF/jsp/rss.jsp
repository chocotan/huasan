<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/xml" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/c" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<rss version="2.0">
<channel>
<title><![CDATA[天羽的部落格正式版v1.0]]></title>
<description><![CDATA[喵]]></description>
<link>http://loli.io</link>
<language>zh</language>
<generator>choco's rss</generator>
<c:forEach var="post" items="${posts}">
<item>
<title>${post.title}</title>
<link>http://loli.io/post?id=${post.id}</link>
<pubDate><fmt:formatDate value="${post.pubDate}" pattern="EEE, d MMM yyyy HH:mm:ss Z"></fmt:formatDate></pubDate>
<author>${post.author_email}(${post.author_name})</author>
<description><![CDATA[${post.content}]]></description>
<guid isPermaLink="false">http://loli.io/post?id=${post.id}</guid>
</item>
</c:forEach>
</channel>
</rss>
