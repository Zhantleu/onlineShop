package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.item.Cap;
import kz.aa.shop.onlineShop.service.impl.CapServiceImpl;
import kz.aa.shop.onlineShop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CapServiceImpl capService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model,
                       @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Cap> asd = capService.findAll();
        model.addAttribute("products", asd);


        if (auth != null) {
            User user = userService.findUserByEmail(auth.getName());
            model.addAttribute("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
            model.addAttribute("adminMessage", "Content Available Only for all");
            return "view/index";
        }

        return "/login";
    }
}
