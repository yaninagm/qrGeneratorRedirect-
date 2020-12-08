package com.front.qrGeneratorRedirect.Infrastucture;

import com.front.qrGeneratorRedirect.Domain.QrInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticQrController {

    @Autowired
    private final StaticQrService staticQrService;

    public StaticQrController(StaticQrService staticQrService) {
        this.staticQrService = staticQrService;
    }

    @GetMapping("/qrByProduct")
    public QrInfo getUrlById(@RequestParam(value = "id") Long id) {
        return staticQrService.getQrInfo(id);
    }
}
