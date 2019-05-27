package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.item.ashekey_biym.Alqa;
import kz.aa.shop.onlineShop.model.item.ashekey_biym.Bilezik;
import kz.aa.shop.onlineShop.service.UserService;
import kz.aa.shop.onlineShop.service.ashekey_biym.AlqaService;
import kz.aa.shop.onlineShop.service.ashekey_biym.BilezikService;
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

    private UserService userService;
    private BilezikService bilezikService;
    private AlqaService alqaService;
    private UtilControllers utilControllers;

    @Autowired
    public CategoryController(UserService userService, BilezikService bilezikService, AlqaService alqaService, UtilControllers utilControllers) {
        this.userService = userService;
        this.bilezikService = bilezikService;
        this.alqaService = alqaService;
        this.utilControllers = utilControllers;
    }

    //    Will be change to another method for category list (switch) todo добавить под категорию и изменить view, т.к очень много чего менять придется через бэк
    @RequestMapping(value = "/category-page")
    public String categoryPage(Model model,
                               @RequestParam(value = "category") String category,
                               @RequestParam(value = "subcategory") String subcategory,
                               @RequestParam(value = "page", defaultValue = "1") int page) {

        Optional<User> user = userService.findCurrentUser();
        model.addAttribute("user", Objects.requireNonNullElseGet(user, User::new));
        PageRequest pageable = PageRequest.of(page - 1, 12);
        switch (category) {
            case "ashekey_biym":
                switch (subcategory) {
                    case "alqa":
                        Page<Alqa> pageAlgaList = alqaService.findAll(pageable);
                        model.addAttribute("products", pageAlgaList);
                        utilControllers.pageCountNumber(model, pageAlgaList.getTotalPages());
                        return "view/alqa";
                    case "bilezik":
                        Page<Bilezik> pageList = bilezikService.findAll(pageable);
                        model.addAttribute("products", pageList);
                        utilControllers.pageCountNumber(model, pageList.getTotalPages());
                        return "view/bilezik";
                    case "saqina":
//                        Page<Dombra> pageList = dombraService.findAll(pageable);
//                        model.addAttribute("products", pageList);
//                        utilControllers.pageCountNumber(model, pageList.getTotalPages());
                        break;
                    case "shaspay":
//                        Page<Dombra> pageList = dombraService.findAll(pageable);
//                        model.addAttribute("products", pageList);
//                        utilControllers.pageCountNumber(model, pageList.getTotalPages());
                        break;
                    case "sholpy":
//                        Page<Dombra> pageList = dombraService.findAll(pageable);
//                        model.addAttribute("products", pageList);
//                        utilControllers.pageCountNumber(model, pageList.getTotalPages());
                        break;
                    case "syrga":
//                        Page<Dombra> pageList = dombraService.findAll(pageable);
//                        model.addAttribute("products", pageList);
//                        utilControllers.pageCountNumber(model, pageList.getTotalPages());
                        break;
                }

                break;
            case "clothes":

                break;
            case "music":

                break;
        }

        return "404";
    }
}
