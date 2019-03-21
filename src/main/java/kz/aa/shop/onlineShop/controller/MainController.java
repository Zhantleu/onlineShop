package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.order.Order;
import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.item.Cap;
import kz.aa.shop.onlineShop.model.order.OrderItem;
import kz.aa.shop.onlineShop.service.impl.CapServiceImpl;
import kz.aa.shop.onlineShop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainController {

    private User user;

    @Autowired
    private CapServiceImpl capService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model,
                       @RequestParam(value = "page", defaultValue = "1") int page) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            user = userService.findUserByEmail(auth.getName());

            PageRequest pageable = PageRequest.of(page - 1, 2);
            Page<Cap> pageCapList = capService.findAll(pageable);
            model.addAttribute("products", pageCapList);

            int totalPages = pageCapList.getTotalPages();
            if (totalPages > 0) {
                List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
                model.addAttribute("pageNumbers", pageNumbers);
            }

            return "view/index";
        }

        return "/login";
    }

    @RequestMapping(value = "/addItem",
            params = {"itemId"},
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String addItem(@RequestParam(value = "itemId") String itemId,
                          @RequestParam(value = "categoryType") String categoryType) {
        OrderItem orderItem = new OrderItem();
        Order order = new Order();
        order.setUser(user);
        order.setOrderItem();

        return "view/index";
    }
}
