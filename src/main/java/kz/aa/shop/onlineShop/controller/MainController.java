package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.item.Cap;
import kz.aa.shop.onlineShop.service.impl.base.OrderItemServiceImpl;
import kz.aa.shop.onlineShop.service.impl.base.OrderServiceImpl;
import kz.aa.shop.onlineShop.service.impl.base.UserServiceImpl;
import kz.aa.shop.onlineShop.service.impl.dto.ItemDtoServiceImpl;
import kz.aa.shop.onlineShop.service.impl.item.CapServiceImpl;
import kz.aa.shop.onlineShop.util.UtilControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class MainController {

    private Optional<User> user;

    private final CapServiceImpl capService;
    private final UserServiceImpl userService;
    private final UtilControllers utilControllers;
    private final OrderServiceImpl orderService;
    private final OrderItemServiceImpl orderItemService;
    private final ItemDtoServiceImpl itemDtoService;


    @Autowired
    public MainController(CapServiceImpl capService, UserServiceImpl userService, UtilControllers utilControllers, OrderServiceImpl orderService, OrderItemServiceImpl orderItemService, ItemDtoServiceImpl itemDtoService) {
        this.capService = capService;
        this.userService = userService;
        this.utilControllers = utilControllers;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
        this.itemDtoService = itemDtoService;
    }

//    Should add a more flexible for new items iteration
    @RequestMapping(value = {"/home","/"}, method = RequestMethod.GET)
    public String home(Model model,
                       @RequestParam(value = "page", defaultValue = "1") int page,
                       HttpServletRequest request) {

        UtilControllers.checkUserInSession(model, request,user, userService);

        PageRequest pageable = PageRequest.of(page - 1, 6);
        Page<Cap> pageCapList = capService.findAll(pageable);
        model.addAttribute("products", pageCapList);

        utilControllers.pageCountNumber(model, pageCapList.getTotalPages());

        return "view/index";

    }

    @RequestMapping(value = "/shopping-cart")
    private String customerBasket(Model model,
                                  HttpServletRequest request) {

        UtilControllers.checkUserInSession(model, request,user, userService);

        return "view/cart";
    }

}
