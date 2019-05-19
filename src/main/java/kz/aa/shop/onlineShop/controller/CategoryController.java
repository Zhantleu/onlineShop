package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.item.music.Dombra;
import kz.aa.shop.onlineShop.service.DombraService;
import kz.aa.shop.onlineShop.service.UserService;
import kz.aa.shop.onlineShop.service.impl.item.CapServiceImpl;
import kz.aa.shop.onlineShop.util.UtilControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.Optional;

@Controller
public class CategoryController {

    private final CapServiceImpl capService;
    private UserService userService;
    private DombraService dombraService;
    private UtilControllers utilControllers;

    @Autowired
    public CategoryController(CapServiceImpl capService, UserService userService, DombraService dombraService, UtilControllers utilControllers) {
        this.capService = capService;
        this.userService = userService;
        this.dombraService = dombraService;
        this.utilControllers = utilControllers;
    }

//    Will be change to another method for category list (switch)
    @RequestMapping(value = "/dombra")
    public String dombraPage(Model model,
                             @RequestParam(value = "page", defaultValue = "1") int page) {

        Optional<User> user = userService.findCurrentUser();

        model.addAttribute("user", Objects.requireNonNullElseGet(user, User::new));

        PageRequest pageable = PageRequest.of(page - 1, 12);
        Page<Dombra> pageList = dombraService.findAll(pageable);
        model.addAttribute("products", pageList);

        utilControllers.pageCountNumber(model, pageList.getTotalPages());

        return "view/dombra_category";
    }
}
