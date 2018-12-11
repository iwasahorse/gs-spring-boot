package hello;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ErrorInterceptor extends HandlerInterceptorAdapter {
    private MyErrorController controller;
    private String uri;

    public ErrorInterceptor(MyErrorController controller){
        this.controller = controller;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
        this.uri = request.getRequestURI();

        System.out.println("////////////////////////////////////");
        System.out.println("preHandle: " + uri);
        System.out.println("////////////////////////////////////");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);

        System.out.println("postHandle: " + uri);
        System.out.println(handler);
        modelAndView.setViewName(controller.getErrorPath() + modelAndView.getViewName());
    }
}
