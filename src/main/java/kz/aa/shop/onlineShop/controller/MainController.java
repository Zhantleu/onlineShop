package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.dto.OrderDto;
import kz.aa.shop.onlineShop.dto.OrderItemDto;
import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.item.Cap;
import kz.aa.shop.onlineShop.service.impl.base.OrderItemServiceImpl;
import kz.aa.shop.onlineShop.service.impl.base.OrderServiceImpl;
import kz.aa.shop.onlineShop.service.impl.base.UserServiceImpl;
import kz.aa.shop.onlineShop.service.impl.dto.ItemDtoServiceImpl;
import kz.aa.shop.onlineShop.service.impl.dto.OrderDtoServiceImpl;
import kz.aa.shop.onlineShop.service.impl.dto.OrderItemDtoServiceImpl;
import kz.aa.shop.onlineShop.service.impl.item.CapServiceImpl;
import kz.aa.shop.onlineShop.util.UtilControllers;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
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
    private final OrderItemDtoServiceImpl orderItemDtoService;
    private final OrderDtoServiceImpl orderDtoService;

    @Autowired
    public MainController(CapServiceImpl capService, UserServiceImpl userService, UtilControllers utilControllers, OrderServiceImpl orderService, OrderItemServiceImpl orderItemService, ItemDtoServiceImpl itemDtoService, OrderItemDtoServiceImpl orderItemDtoService, OrderDtoServiceImpl orderDtoService) {
        this.capService = capService;
        this.userService = userService;
        this.utilControllers = utilControllers;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
        this.itemDtoService = itemDtoService;
        this.orderItemDtoService = orderItemDtoService;
        this.orderDtoService = orderDtoService;
    }

    //    Should add a more flexible for new items iteration
    @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
    public String home(Model model,
                       @RequestParam(value = "page", defaultValue = "1") int page,
                       HttpServletRequest request) {

        user = utilControllers.checkUserInSession(model, request, user, userService);

        model.addAttribute("user", Objects.requireNonNullElseGet(user, User::new));
        PageRequest pageable = PageRequest.of(page - 1, 12);
        Page<Cap> pageCapList = capService.findAll(pageable);
        model.addAttribute("products", pageCapList);

        utilControllers.pageCountNumber(model, pageCapList.getTotalPages());

        return "view/index";

    }

    @RequestMapping(value = "/shopping-cart")
    public String customerBasket(Model model,
                                 HttpServletRequest request) {

        user = utilControllers.checkUserInSession(model, request, user, userService);
        model.addAttribute("user", Objects.requireNonNullElseGet(user, User::new));

        if (user.isPresent()) {
            List<OrderItemDto> orderItemDtoList = orderItemDtoService.findByOrder(orderService.findByUserAndIsConfirmedIsFalse(user.get()));
            OrderDto orderDto = orderDtoService.findItemOfOrder(orderItemDtoList);
            model.addAttribute("order", orderDto);
        }

        return "view/cart";
    }

    @PostMapping(value = "/create-order")
    public String createOrder(@ModelAttribute OrderDto order,
                              Model model,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              HttpServletRequest request) {

        user = utilControllers.checkUserInSession(model, request, user, userService);

        model.addAttribute("user", Objects.requireNonNullElseGet(user, User::new));

        PageRequest pageable = PageRequest.of(page - 1, 6);
        Page<Cap> pageCapList = capService.findAll(pageable);
        model.addAttribute("products", pageCapList);

        utilControllers.pageCountNumber(model, pageCapList.getTotalPages());

        return "redirect:home";
    }
}
