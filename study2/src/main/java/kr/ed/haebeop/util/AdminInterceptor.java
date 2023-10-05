package kr.ed.haebeop.util;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");
        
        if(sid == null){                    // 로그인을 하지 않은 경우
            response.sendRedirect(request.getContextPath() + "/user/loginForm");
            return false;
        }
        
        if(sid.equals("admin")) {           // 로그인한 아이디가 admin 인 경우
            return true;
        } else {                            // 로그인한 아이디가 admin 아닌 경우
            response.sendRedirect(request.getContextPath() + "/user/loginForm");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

}
