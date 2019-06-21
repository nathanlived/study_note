package com.github.nicejing.security.security.support;


import com.alibaba.fastjson.JSONObject;
import com.github.nicejing.security.utils.ResultBean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限拒绝处理
 * @author Nathan
 */
@Component
public class AdminAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // 获取获取信息
        response.getWriter().write(JSONObject.toJSONString(ResultBean.fail("权限不足")));
    }
}
