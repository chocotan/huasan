<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<div class="foot">
:copyright: 2013 loli.lt
</div>
<script>
$("input#username").attr("value", $.cookie('nickname'));
$("input#email").attr("value", $.cookie('email'));
$("input#website").attr("value", $.cookie('website'));
</script>
</body>
</html>