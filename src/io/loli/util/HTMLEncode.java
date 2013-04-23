package io.loli.util;

public class HTMLEncode {
	public static String html(String content) {
		if (content == null)
			return "";
		String html = content;

		// html = html.replace( "'", "&apos;");
		// html = html.replaceAll( "&", "&amp;");
		// html = html.replace( "\"", "&quot;"); //"
		// html = html.replace( "\t", "&nbsp;&nbsp;");// 替换跳格
		// html = html.replace( " ", "&nbsp;");// 替换空格
		html = html.replace("<", "&lt;");
		html = html.replaceAll(">", "&gt;");
		return html;
	}
}
