package hello;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Interceptor extends HandlerInterceptorAdapter {

    private String uri;

    public Interceptor(){}

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
        this.uri = request.getRequestURI();

        System.out.println("////////////////////////////////////");
        System.out.println("preHandle: " + uri);
        System.out.println("////////////////////////////////////");
        return true;
    }
}// end of class
