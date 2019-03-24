package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.item.Cap;
import kz.aa.shop.onlineShop.model.property.ColorEnum;
import kz.aa.shop.onlineShop.model.property.Gender;
import kz.aa.shop.onlineShop.model.property.MaterialEnum;
import kz.aa.shop.onlineShop.model.property.SizeEnum;
import kz.aa.shop.onlineShop.service.PropertyCapService;
import kz.aa.shop.onlineShop.service.impl.CapServiceImpl;
import kz.aa.shop.onlineShop.util.UtilImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
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

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final CapServiceImpl capService;
    private final PropertyCapService propertyCapService;
    private final UtilImage utilImage;

    private String uploadPath;

    @Autowired
    public AdminController(CapServiceImpl capService, UtilImage utilImage, ApplicationContext applicationContext, PropertyCapService propertyCapService) throws IOException {
        this.capService = capService;
        this.utilImage = utilImage;
        this.propertyCapService = propertyCapService;

        Resource resource = applicationContext.getResource("img_src");
        uploadPath = resource.getFile().getAbsolutePath();
    }


    @RequestMapping(value = "/admin/page", method = RequestMethod.GET)
    public String mainForAdmin(Model model) {
        model.addAttribute("cap", new Cap());
        model.addAttribute("genderTypes", Gender.values());
        model.addAttribute("colorEnum", ColorEnum.values());
        model.addAttribute("sizeEnum", SizeEnum.values());
        model.addAttribute("materialEnum", MaterialEnum.values());

        return "admin/page";
    }

    @RequestMapping(value = "/admin/page", method = RequestMethod.POST, headers = "content-type=multipart/*")
    public String createItem(Model model,
                             @ModelAttribute("cap") @Valid Cap cap,
                             BindingResult bindingResult,
                             @RequestParam("file") MultipartFile file
    ) throws IOException {

        if (!bindingResult.hasErrors()) {
//            model.addAttribute("userForm", userForm); //THIS LINE IS ADDED
            model.addAttribute("url", cap);
            return "/admin/page";
        } else {

            cap.setUrlImage(utilImage.saveFile(file, uploadPath));
            cap.getPropertyCap().setCap(cap);

            capService.saveOrUpdate(cap);

            return "redirect:/admin/page";
        }
    }
}
