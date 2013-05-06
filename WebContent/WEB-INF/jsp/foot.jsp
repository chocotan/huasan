<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	$("input#username").attr("value", $.cookie('nickname'));
	$("input#email").attr("value", $.cookie('email'));
	$("input#website").attr("value", $.cookie('website'));
</script>
<div class="foot">
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
Powered by <a href="https://openshift.redhat.com/" target="_blank">OpenShift</a>|<a href="https://plus.google.com/111640188967873277027?rel=author">天羽ちよこ</a>|Since 2012|<a href="http://validator.w3.org/check?uri=http%3A%2F%2Floli.io%2F" target="_blank"><img style="border:0;width:auto;height:31px;"
        src="/img/html5-custom.png"
        alt="Valid html5!" /></a>|
<a href="http://jigsaw.w3.org/css-validator/validator?uri=http%3A%2F%2Floli.io&amp;profile=css3&amp;usermedium=all&amp;warning=1&amp;vextwarning=&amp;lang=zh-cn
" target="_blank">
    <img style="border:0;width:auto;height:31px;"
        src="/img/vcss-blue.gif"
        alt="Valid CSS!" />
</a>
</div>
</body>
</html>