package kz.aa.shop.onlineShop.controller.admin;

import kz.aa.shop.onlineShop.model.item.ashekey_biym.Alqa;
import kz.aa.shop.onlineShop.service.ashekey_biym.AlqaService;
import kz.aa.shop.onlineShop.util.UtilImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@PreFilter("authentication.principal.username != null")
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/admin/createItem")
public class CreateItemController {

    private final UtilImage utilImage;
    private final AlqaService alqaService;

    private String uploadPath;

    @Autowired
    public CreateItemController(UtilImage utilImage, AlqaService alqaService, ApplicationContext applicationContext) throws IOException {
        this.alqaService = alqaService;
        this.utilImage = utilImage;

        Resource resource = applicationContext.getResource("img_src");
        uploadPath = resource.getFile().getAbsolutePath();
    }

    @RequestMapping(method = RequestMethod.POST, params = "type")
    public ModelAndView save(@ModelAttribute("product") Alqa alqa,
                             @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        if (file != null)
            alqa.setUrlImage(utilImage.saveFile(file, uploadPath));

        alqaService.saveOrUpdate(alqa);

        return new ModelAndView("redirect:/home");
    }
}
