package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.item.Cap;
import kz.aa.shop.onlineShop.service.impl.CapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Autowired
    private CapServiceImpl capService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model,
                       @RequestParam(value = "page", defaultValue = "1") int page) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        PageRequest pageable = PageRequest.of(page - 1, 2);
        Page<Cap> pageCapList = capService.findAll(pageable);
        model.addAttribute("products", pageCapList);

        int totalPages = pageCapList.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        if (auth != null) {
            return "view/index";
        }

        return "/login";
    }
}
