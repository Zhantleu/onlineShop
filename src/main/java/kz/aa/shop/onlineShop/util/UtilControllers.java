package kz.aa.shop.onlineShop.util;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import kz.aa.shop.onlineShop.service.clothes.CapService;
import kz.aa.shop.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UtilControllers {
    @Autowired
    private CapService capService;

    public static Map<String, String> getErrors(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );
        return bindingResult.getFieldErrors().stream().collect(collector);
    }

    public Optional<User> checkUserInSession(Model model, HttpServletRequest request, UserService userService) {
        Optional<User> user;
        if (request.getSession().getAttribute("loggedInUser") != null)
            user = (Optional<User>) request.getSession().getAttribute("loggedInUser");
        else
            user = userService.findCurrentUser();

        model.addAttribute("user", user);

        return user;
    }

    public void pageCountNumber(Model model, int totalPages) {
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
    }

    public String checkTypeCategory(Model model, TypeCategory typeCategory, Long id) {
        switch (typeCategory) {
            case CAP:
                model.addAttribute("product",capService.findById(id));
                return "view/product_info";
        }

        return null;
    }
}
