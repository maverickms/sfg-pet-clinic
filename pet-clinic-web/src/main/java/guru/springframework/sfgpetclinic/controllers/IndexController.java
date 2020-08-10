package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/oups"})
    public String oups() {
        return "underconstruction";
    }
}
