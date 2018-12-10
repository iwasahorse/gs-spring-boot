package hello;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Component;


//@Controller
@Component
public class MyErrorController implements ErrorController {
    /*@GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);


        System.out.println("This is error!");

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "505";
            }
        }
        return "404";
    }*/

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
