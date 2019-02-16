package kz.aa.shop.onlineShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
    @RequestMapping("/403")
    public String errorHandler() {
        return "/error/403.html";
    }
}
