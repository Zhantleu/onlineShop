package kz.aa.shop.onlineShop;

import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.Order;
import kz.aa.shop.onlineShop.model.order.OrderItem;
import kz.aa.shop.onlineShop.service.OrderItemService;
import kz.aa.shop.onlineShop.service.OrderService;
import kz.aa.shop.onlineShop.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    private OrderService mockOrderService;

    @Mock
    private UserService userService;

    @Mock
    private OrderItemService mockOrderItemService;

    @Test
    public void addToDb() {
        Optional<User> user = userService.findUserByEmail("123@gmail.com");
        System.out.println(user);
        Order order = new Order(user.get(), LocalDateTime.now(), false);

        OrderItem orderItem = new OrderItem(order, 1L, LocalDateTime.now(), TypeCategory.CAP);

        mockOrderService.saveOrUpdate(order);

        Assert.assertEquals(order, mockOrderService.findByUserAndIsConfirmedIsFalse(user.get()));

        mockOrderItemService.saveOrUpdate(orderItem);

        Assert.assertEquals(orderItem, mockOrderItemService.findByOrder(order));
    }
}