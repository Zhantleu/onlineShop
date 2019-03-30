package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.item.Cap;
import kz.aa.shop.onlineShop.service.UserService;
import kz.aa.shop.onlineShop.service.impl.CapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CategoryController {

    private final CapServiceImpl capService;
    private UserService userService;

    @Autowired
    public CategoryController(CapServiceImpl capService, UserService userService) {
        this.capService = capService;
        this.userService = userService;
    }

    @RequestMapping(value = "/dombra")
    public String dombraPage(Model model,
                             @RequestParam(value = "page", defaultValue = "1") int page) {

        User user = userService.findCurrentUser();

        model.addAttribute("user", Objects.requireNonNullElseGet(user, User::new));

        PageRequest pageable = PageRequest.of(page - 1, 12);
        Page<Cap> pageCapList = capService.findAll(pageable);
        model.addAttribute("products", pageCapList);

        model.addAttribute("products", pageCapList);

        int totalPages = pageCapList.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "view/dombra_category";
    }
}
