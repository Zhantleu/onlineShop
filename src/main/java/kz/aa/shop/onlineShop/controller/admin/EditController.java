package kz.aa.shop.onlineShop.controller.admin;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.item.clothes.Cap;
import kz.aa.shop.onlineShop.model.property.enumeration.*;
import kz.aa.shop.onlineShop.service.UserService;
import kz.aa.shop.onlineShop.service.clothes.CapService;
import kz.aa.shop.onlineShop.util.UtilImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Controller
@PreFilter("authentication.principal.username != null")
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/admin/edit-page")
public class EditController {

    private final UserService userService;
    private final CapService capService;
    private final UtilImage utilImage;

    private String uploadPath;

    @Autowired
    public EditController(UserService userService, CapService capService, UtilImage utilImage, ApplicationContext applicationContext) throws IOException {
        this.userService = userService;
        this.capService = capService;
        this.utilImage = utilImage;

        Resource resource = applicationContext.getResource("img_src");
        uploadPath = resource.getFile().getAbsolutePath();
    }

    @GetMapping
    public String editPage(Model model,
                           @RequestParam(value = "subTypeCategory") SubTypeCategory subTypeCategory,
                           @RequestParam(value = "idItem") Long id) {

        Optional<User> user = userService.findCurrentUser();

        model.addAttribute("user", Objects.requireNonNullElseGet(user, User::new));

        switch (subTypeCategory) {
            case CAP:
                model.addAttribute("genderTypes", Gender.values());
                model.addAttribute("colorEnum", ColorEnum.values());
                model.addAttribute("sizeEnum", SizeEnum.values());
                model.addAttribute("materialEnum", MaterialEnum.values());
                model.addAttribute("product", capService.findById(id));
                return "/admin/edit_page";
        }

        return null;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST, params = "action=save")
    public ModelAndView save(@ModelAttribute("product") @Valid Cap cap,
                             @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        if (file != null)
            cap.setUrlImage(utilImage.saveFile(file, uploadPath));

        capService.saveOrUpdate(cap);

        return new ModelAndView("redirect:/home");
    }

//    change after
//    @ModelAttribute("countries")
//    public Map<String, String> initializeCountries() {
//
//        Map<String, String> countries = new TreeMap<>();
//
//        String[] locales = Locale.getISOCountries();
//        for (String countryCode : locales) {
//            Locale obj = new Locale("", countryCode);
//            countries.put(obj.getDisplayCountry(), obj.getCountry());
//        }
//
//        return countries;
//    }


    @RequestMapping(value = "edit", method = RequestMethod.POST, params = "action=delete")
    public ModelAndView cancel(@ModelAttribute("product") @Valid Cap cap) {

        cap.setIsUsed(false);
        capService.saveOrUpdate(cap);

        return new ModelAndView("redirect:/home");
    }
}
