package colval.qc.ca.examen_1.controllers;

import colval.qc.ca.examen_1.services.impl.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class indexController {


    @GetMapping("/") //@GetMapping source de fichiers == ressources/templates
    public String index(Model model) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        model.addAttribute("myName", "Vincent Chartier");
        model.addAttribute("date", format.format(new Date()));//addAttribute(variable name, objectToBind)
        return "index/index"; //folder/file
    }


}
