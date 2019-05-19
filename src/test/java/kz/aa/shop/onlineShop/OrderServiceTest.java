//package kz.aa.shop.onlineShop;
//
//import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
//import kz.aa.shop.onlineShop.model.User;
//import kz.aa.shop.onlineShop.model.customerOrder.CustomerOrder;
//import kz.aa.shop.onlineShop.model.customerOrder.OrderItem;
//import kz.aa.shop.onlineShop.service.OrderItemService;
//import kz.aa.shop.onlineShop.service.CustomerOrderService;
//import kz.aa.shop.onlineShop.service.UserService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//@RunWith(MockitoJUnitRunner.class)
//public class OrderServiceTest {
//
//    @Mock
//    private CustomerOrderService mockOrderService;
//
//    @Mock
//    private UserService userService;
//
//    @Mock
//    private OrderItemService mockOrderItemService;
//
//    @Test
//    public void addToDb() {
//        Optional<User> user = userService.findUserByEmail("123@gmail.com");
//        System.out.println(user);
//        CustomerOrder customerOrder = new CustomerOrder(user.get(), false);
//
//        OrderItem orderItem = new OrderItem(customerOrder, 1L, LocalDateTime.now(), TypeCategory.CAP);
//
//        mockOrderService.saveOrUpdate(customerOrder);
//
//        Assert.assertEquals(customerOrder, mockOrderService.findByUserAndIsConfirmedIsFalse(user.get()));
//
//        mockOrderItemService.saveOrUpdate(orderItem);
//
//        Assert.assertEquals(orderItem, mockOrderItemService.findByOrder(customerOrder));
//    }
//}