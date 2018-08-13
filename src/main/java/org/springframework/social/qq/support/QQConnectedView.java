package org.springframework.social.qq.support;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.view.AbstractView;

/**
 * QQ 绑定成功视图。
 * @author Ben
 * @since 1.0.0
 * @version 1.0.0
 */
public class QQConnectedView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType(MediaType.TEXT_HTML_VALUE);
		response.getWriter().write("QQ登录绑定成功");
	}
	
}
