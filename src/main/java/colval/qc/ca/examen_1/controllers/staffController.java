package colval.qc.ca.examen_1.controllers;

import colval.qc.ca.examen_1.model.enitties.Customer;
import colval.qc.ca.examen_1.model.enitties.Staff;
import colval.qc.ca.examen_1.services.impl.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class staffController {
    StaffService staffService;

    public staffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/all")
    public ModelAndView customer(){
        long id = 0;
        ModelAndView modelAndView = new ModelAndView("Staff/staff");
        modelAndView.addObject("searchStoreId", id);
        modelAndView.addObject("allStaff", staffService.readAll());
        return modelAndView;
    }

    @PostMapping("/doSearchStore")
    public String searchCustomersByName(Model model, @ModelAttribute("searchStoreId") long id){
        List<Staff> staffs = staffService.getAllStaffByStoreId(id);
        model.addAttribute("searchStoreId", 0);
        model.addAttribute("allStaff", staffs);
        return "Staff/staff";
    }

}
