package com.front.qrGeneratorRedirect.Infrastucture;

import com.front.qrGeneratorRedirect.Domain.QrInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StaticQrController {

    @Autowired
    private final StaticQrService staticQrService;

    public StaticQrController(StaticQrService staticQrService) {
        this.staticQrService = staticQrService;
    }

    @GetMapping("/qrByProduct")
    public String getUrlById(@RequestParam(value = "id") String id, Model model) {
        String dinamicUrl = staticQrService.getDinamicUrl(id);
        model.addAttribute("dinamicUrl", dinamicUrl);
        return "qrRedirect";
    }

    @GetMapping("/productIdentifier/qrImage")
    public String getQrImage(@RequestParam(value = "id") Long id, Model model) {
        String qrImage = staticQrService.getQrImage(id);
        model.addAttribute("qrImage", qrImage);
        System.out.println(">>>>>> "+ qrImage);
        return "qrImage";
    }

    @GetMapping("/productIdentifier")
    public String productIdentifierForm(Model model) {
        model.addAttribute("qrInfo", new QrInfo());
        System.out.println(">>>>>>>>>>> model: " + model);
        //staticQrService.getProductIdentifier(model.getAttribute("urlQrId").toString());
        return "productIdentifier";
    }

    @PostMapping("/productIdentifier")
    public String productIdentifierSubmit(@ModelAttribute QrInfo qrInfo, Model model) {
        model.addAttribute("qrInfo", qrInfo);
        staticQrService.createProductIdentifier(qrInfo);
        return "result";
    }
}
