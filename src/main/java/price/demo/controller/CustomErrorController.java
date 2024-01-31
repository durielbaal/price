package price.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {
    public static final String API_ERROR_BASE_PATH ="/error";
    @RequestMapping(API_ERROR_BASE_PATH)
    public String handleError() {
        // Redirige a mi propia página de error personalizada
        return "<h1>Esta es mi página de error personalizada</h1>";
    }
}

