package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.dto.OrderDto;
import kz.aa.shop.onlineShop.dto.OrderItemDto;
import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.item.Cap;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import kz.aa.shop.onlineShop.model.order.OrderItem;
import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import kz.aa.shop.onlineShop.service.impl.base.CustomerOrderServiceImpl;
import kz.aa.shop.onlineShop.service.impl.base.OrderItemServiceImpl;
import kz.aa.shop.onlineShop.service.impl.base.UserServiceImpl;
import kz.aa.shop.onlineShop.service.impl.dto.ItemDtoServiceImpl;
import kz.aa.shop.onlineShop.service.impl.dto.OrderDtoServiceImpl;
import kz.aa.shop.onlineShop.service.impl.dto.OrderItemDtoServiceImpl;
import kz.aa.shop.onlineShop.service.impl.item.CapServiceImpl;
import kz.aa.shop.onlineShop.util.UtilControllers;
import kz.aa.shop.onlineShop.util.UtilConvertFromDtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class MainController {

    private Optional<User> user;

    private final CapServiceImpl capService;
    private final UserServiceImpl userService;
    private final UtilControllers utilControllers;
    private final CustomerOrderServiceImpl orderService;
    private final OrderItemServiceImpl orderItemService;
    private final ItemDtoServiceImpl itemDtoService;
    private final OrderItemDtoServiceImpl orderItemDtoService;
    private final OrderDtoServiceImpl orderDtoService;
    private final UtilConvertFromDtoToEntity convertFromDtoToEntity;

    @Autowired
    public MainController(CapServiceImpl capService, UserServiceImpl userService, UtilControllers utilControllers, CustomerOrderServiceImpl orderService, OrderItemServiceImpl orderItemService, ItemDtoServiceImpl itemDtoService, OrderItemDtoServiceImpl orderItemDtoService, OrderDtoServiceImpl orderDtoService, UtilConvertFromDtoToEntity convertFromDtoToEntity) {
        this.capService = capService;
        this.userService = userService;
        this.utilControllers = utilControllers;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
        this.itemDtoService = itemDtoService;
        this.orderItemDtoService = orderItemDtoService;
        this.orderDtoService = orderDtoService;
        this.convertFromDtoToEntity = convertFromDtoToEntity;
    }

    //    Should add a more flexible for new items iteration
    @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
    public String home(Model model,
                       @RequestParam(value = "page", defaultValue = "1") int page,
                       HttpServletRequest request) {

        user = utilControllers.checkUserInSession(model, request, userService);

        model.addAttribute("user", Objects.requireNonNullElseGet(user, User::new));

        PageRequest pageable = PageRequest.of(page - 1, 12);
        Page<Cap> pageCapList = capService.findAll(pageable);
        model.addAttribute("products", pageCapList);

        utilControllers.pageCountNumber(model, pageCapList.getTotalPages());

        insertValueCartInMainPage(model);
        return "view/index";

    }

    private void insertValueCartInMainPage(Model model) {
        if (user.isPresent())
            model.addAttribute("amountItems", orderItemService.countByCustomerOrder_UserAndCustomerOrder_Confirmed(user.get(), false));
        else
            model.addAttribute("amountItems", "0");
    }

    @RequestMapping(value = "/shopping-cart")
    public String customerBasket(Model model,
                                 HttpServletRequest request) {

        user = utilControllers.checkUserInSession(model, request, userService);

        if (user.isPresent()) {
            CustomerOrder order = orderService.findByUserAndIsConfirmedIsFalse(user.get());
            List<OrderItemDto> orderItemDtoList = orderItemDtoService.findByOrder(order);
            OrderDto orderDto = orderDtoService.findItemOfOrder(orderItemDtoList, order);
            model.addAttribute("order", orderDto);
            request.getSession().setAttribute("order", order);
        }

        return "view/cart";
    }

    @PostMapping(value = "/create-order")
    public String createOrder(@ModelAttribute OrderDto order,
                              Model model,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              HttpServletRequest request) {
        order.setCustomerOrder((CustomerOrder) request.getSession().getAttribute("order"));

        order.getCustomerOrder().setOrderTime(LocalDateTime.now());
        order.getCustomerOrder().setConfirmed(true);

        if (order.getOrderItemDtos() != null) {
            itemDtoService.findByIdAndCategory(order.getOrderItemDtos());

            Double totalPriceForOrderItem = 0D;
            Double totalPriceForOrder = 0D;

            for (OrderItemDto orderItemDto : order.getOrderItemDtos()) {
                totalPriceForOrderItem = orderItemDto.getAmount() * orderItemDto.getPrice();
                totalPriceForOrder += totalPriceForOrderItem;
                orderItemDto.setTotalPrice(totalPriceForOrderItem);
            }

            order.getCustomerOrder().setTotalPrice(totalPriceForOrder);

            orderService.saveOrUpdate(order.getCustomerOrder());
            orderItemService.saveAll(convertFromDtoToEntity.convertFromDtoToOrderItem(order));
        }

        user = utilControllers.checkUserInSession(model, request, userService);

        PageRequest pageable = PageRequest.of(page - 1, 6);
        Page<Cap> pageCapList = capService.findAll(pageable);
        model.addAttribute("products", pageCapList);

        utilControllers.pageCountNumber(model, pageCapList.getTotalPages());

        return "redirect:home";
    }

    @RequestMapping(value = "/product-view", method = RequestMethod.GET)
    public String testMethod(Model model,
                             @RequestParam("typeCategory") TypeCategory typeCategory,
                             @RequestParam("idItem") Long id,
                             HttpServletRequest request) {


        user = utilControllers.checkUserInSession(model, request, userService);
        model.addAttribute("user", user);
        insertValueCartInMainPage(model);
        utilControllers.checkTypeCategory(model, typeCategory, Long.valueOf(id));

        return "view/product_info";
    }
}
