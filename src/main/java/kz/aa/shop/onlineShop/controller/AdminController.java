package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.item.clothes.Cap;
import kz.aa.shop.onlineShop.model.item.music.Dombra;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import kz.aa.shop.onlineShop.model.property.enumeration.*;
import kz.aa.shop.onlineShop.service.order.CustomerOrderService;
import kz.aa.shop.onlineShop.service.music.DombraService;
import kz.aa.shop.onlineShop.service.property.PropertyCapService;
import kz.aa.shop.onlineShop.service.UserService;
import kz.aa.shop.onlineShop.service.impl.item.CapServiceImpl;
import kz.aa.shop.onlineShop.util.UtilImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@PreFilter("authentication.principal.username != null")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final CapServiceImpl capService;
    private final CustomerOrderService customerOrderService;
    private final PropertyCapService propertyCapService;
    private final UtilImage utilImage;

    private String uploadPath;
    private UserService userService;
    private DombraService dombraService;

    @Autowired
    public AdminController(CapServiceImpl capService, CustomerOrderService customerOrderService, UtilImage utilImage, ApplicationContext applicationContext, PropertyCapService propertyCapService, UserService userService, DombraService dombraService) throws IOException {
        this.capService = capService;
        this.customerOrderService = customerOrderService;
        this.utilImage = utilImage;
        this.propertyCapService = propertyCapService;
        this.userService = userService;
        this.dombraService = dombraService;

        Resource resource = applicationContext.getResource("img_src");
        uploadPath = resource.getFile().getAbsolutePath();
    }


    @RequestMapping(value = "/admin/page", method = RequestMethod.GET)
    public String mainForAdmin(Model model) {

        Optional<User> user = userService.findCurrentUser();

        List<CustomerOrder> customerOrderList = customerOrderService.findAllByConfirmedIsTrue();

        model.addAttribute("orders",customerOrderList);
        model.addAttribute("user", Objects.requireNonNullElseGet(user, User::new));
        model.addAttribute("dombra", new Dombra());
        model.addAttribute("cap", new Cap());
        model.addAttribute("genderTypes", Gender.values());
        model.addAttribute("colorEnum", ColorEnum.values());
        model.addAttribute("sizeEnum", SizeEnum.values());
        model.addAttribute("materialEnum", MaterialEnum.values());

        return "admin/page";
    }

    @RequestMapping(value = "/admin/create-cap",
            method = RequestMethod.POST,
            headers = "content-type=multipart/*")
    public String createItemCap(Model model,
                             @ModelAttribute("cap") @Valid Cap cap,
                             BindingResult bindingResult,
                             @RequestParam("file") MultipartFile file
    ) throws IOException {

        if (!bindingResult.hasErrors()) {
            model.addAttribute("url", cap);
            return "/admin/page";
        } else {

            cap.setUrlImage(utilImage.saveFile(file, uploadPath));
            cap.getPropertyCap().setCap(cap);
            cap.setTypeCategory(TypeCategory.CAP);

            capService.saveOrUpdate(cap);

            return "redirect:/admin/page";
        }
    }

    @RequestMapping(value = "/admin/create-dombra",
            method = RequestMethod.POST,
            headers = "content-type=multipart/*")
    public String createItemDombra(Model model,
                             @ModelAttribute("dombra") @Valid Dombra dombra,
                             BindingResult bindingResult,
                             @RequestParam("file") MultipartFile file
    ) throws IOException {

        if (!bindingResult.hasErrors()) {
            model.addAttribute("url", dombra);

            return "/admin/page";
        } else {

            dombra.setUrlImage(utilImage.saveFile(file, uploadPath));
            dombra.getPropertyDombra().setDombra(dombra);
            dombra.setTypeCategory(TypeCategory.DOMBRA);

            dombraService.saveOrUpdate(dombra);

            return "redirect:/admin/page";
        }
    }
}
