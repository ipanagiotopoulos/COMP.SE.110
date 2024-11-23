package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotFoundController {

    @RequestMapping("/404.html")
    public String notFoundResponse() {
        return "404";
    }
}
