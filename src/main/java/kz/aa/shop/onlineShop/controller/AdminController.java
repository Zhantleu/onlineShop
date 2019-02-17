package kz.aa.shop.onlineShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
    @RequestMapping(name = "/admin/main", method = RequestMethod.GET)
    public String main() {
        return "admin/page";
    }
}
