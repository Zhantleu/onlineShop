package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.service.UserService;
import kz.aa.shop.onlineShop.service.impl.base.UserServiceImpl;
import kz.aa.shop.onlineShop.util.ErrorMessage;
import kz.aa.shop.onlineShop.util.ValidationResponse;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {
    private final UserServiceImpl userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(BCryptPasswordEncoder passwordEncoder,
                           UserServiceImpl userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PostMapping(value="login",produces="application/json")
    public @ResponseBody
    ValidationResponse loginViaAjax(Model model,
                                    @ModelAttribute(value="user") User user,
                                    BindingResult result, HttpServletRequest request) {

        ValidationResponse res = new ValidationResponse();

        if (result.hasErrors()) {

            res.setStatus("FAIL");
            List<FieldError> allErrors = result.getFieldErrors();
            final List<ErrorMessage> errorMessages = new ArrayList<>();
            allErrors.forEach((objectError) -> errorMessages.add(new ErrorMessage(objectError.getField(), objectError.getDefaultMessage())));
            res.setErrorMessageList(errorMessages);

        } else {

            Optional<User> theUser = userService.findUserByEmail(user.getEmail());
            final List<ErrorMessage> errorMessagelist = new ArrayList<>();

            if (theUser.isPresent()) {

                if (passwordEncoder.matches(user.getPassword(), theUser.get().getPassword())) {
                    uploadUserAttributesToSession(theUser, request);
                    res.setStatus("SUCCESS");

                } else {
                    res.setStatus("FAIL");
                    errorMessagelist.add(new ErrorMessage("password", "Неверный пароль!"));
                }

            } else {
                res.setStatus("FAIL");
                errorMessagelist.add(new ErrorMessage("FORM FAIL", "Неверный логин или пароль!"));
            }

            res.setErrorMessageList(errorMessagelist);
        }
        return res;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<User> userExists = userService.findUserByEmail(user.getEmail());

        if (userExists.isPresent()) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("redirect:/home");
        } else {
            user.setRegistrationDate(LocalDateTime.now());
            userService.saveUser(user);
            modelAndView.addObject("user", new User());

            modelAndView.setViewName("redirect:/home");
        }
        return modelAndView;
    }

    private void uploadUserAttributesToSession(Optional<User> theUser, HttpServletRequest request) {
        request.getSession().setAttribute("loggedInUser", theUser);
    }
}
