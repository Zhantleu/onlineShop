package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            User user = userService.findUserByEmail(auth.getName());
            model.addAttribute("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
            model.addAttribute("adminMessage", "Content Available Only for all");

            return "view/index";
        }

        return "/login";
    }

    @RequestMapping(value = "/usersList", method = RequestMethod.GET)
    public String usersList(Model model) {

        System.out.println(userService.findAll());

        model.addAttribute("users",userService.findAll());

        return "view/users";
    }

}
