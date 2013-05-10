<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="link.jsp"/>
<div class="foot">
	Powered by <a href="https://openshift.redhat.com/" target="_blank">OpenShift</a>|<a
		href="https://plus.google.com/111640188967873277027?rel=author">天羽ちよこ</a>|Since
	2012
</div>
<script>
	$("input#username").attr("value", $.cookie('nickname'));
	$("input#email").attr("value", $.cookie('email'));
	$("input#website").attr("value", $.cookie('website'));
</script>
</body>
</html>