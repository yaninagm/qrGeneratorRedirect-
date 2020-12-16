package com.front.qrGeneratorRedirect.Infrastucture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StaticQrController {

    @Autowired
    private final StaticQrService staticQrService;

    public StaticQrController(StaticQrService staticQrService) {
        this.staticQrService = staticQrService;
    }

    @GetMapping("/qrByProduct")
    public String getUrlById(@RequestParam(value = "id") Long id, Model model) {
        String name = staticQrService.getQrInfo(id);
        model.addAttribute("name", name);
        return "qrRedirect";
    }
}
