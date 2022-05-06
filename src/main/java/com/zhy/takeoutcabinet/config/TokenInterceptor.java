package com.zhy.takeoutcabinet.config;

import com.zhy.takeoutcabinet.utils.ResponseJSON;
import com.zhy.takeoutcabinet.utils.TokenUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

// @Component将拦截器注入容器
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        System.out.println("token: " + token);
        if(token != null){
            // 验证 token
            boolean result = TokenUtils.verify(token);
            if(result){
//                System.out.println("通过拦截器");
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try{
            Map<String, Object> error = ResponseJSON.error500("token verify fail");
            response.getWriter().write(error.toString());
//            System.out.println("认证失败，未通过拦截器");
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;
    }
}
