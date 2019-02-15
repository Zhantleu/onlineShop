package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(name = "/login")
    public String login(@ModelAttribute(name = "user") @Valid User user,
                        Model model) {
        return "login.html";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUser(
            @ModelAttribute(name = "user") @Valid User user,
            Model model) {

          if (!userService.addUser(user)) {
            model.addAttribute("usernameError", "User exists!");
            return "registration";
          }

        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration.html";
    }
}
