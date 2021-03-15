package colval.qc.ca.examen_1.controllers;

import colval.qc.ca.examen_1.model.enitties.Customer;
import colval.qc.ca.examen_1.services.impl.CustomerService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class customerController {
    CustomerService customerService;

    public customerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ModelAndView customer(){
        ModelAndView modelAndView = new ModelAndView("customer/customers");
        modelAndView.addObject("searchFirstName", new String());
        modelAndView.addObject("searchLastName", new String());
        modelAndView.addObject("allCustomer", customerService.findAllCustomerIdDescAndLimit50());
        modelAndView.addObject("nbCustomer", customerService.countAllCustomer());
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateView(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("customer/updateCustomer");
        Optional<Customer> getCustomer = customerService.readOne(id);
        Customer customer = null;
        if (getCustomer.isPresent()){
            customer = getCustomer.get();
        }
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping(value="/update/{id}")
    public String updateCustomer(@PathVariable Long id,@ModelAttribute("customer") Customer customer){
        customerService.updateFirstNameAndLastName(id, customer.getFirstName(), customer.getLastName());
        return "redirect:/customer/showCustomer/" + id;
    }

    @GetMapping("/showCustomer/{id}")
    public String getcustomer(@PathVariable Long id,Model model){
        Optional<Customer> customer = customerService.readOne(id);
        String firstName = customer.map(Customer::getFirstName).orElse("");
        String lastName = customer.map(Customer::getLastName).orElse("");
        String email = customer.map(Customer::getEmail).orElse("");
        model.addAttribute("getFirstName", firstName);
        model.addAttribute("getLastName", lastName);
        model.addAttribute("getEmail", email);
        return "customer/customer";
    }

    @PostMapping("/doSearchNames")
    public String searchCustomersByName(Model model, @ModelAttribute("searchFirstName") String firstName, @ModelAttribute("searchLastName") String lastName){
        System.out.println(firstName);
        List<Customer> customers = customerService.getAllCustomerWithFirstNameAndLastNameSubStr(firstName, lastName);
        int nbCustomer = customers.size();
        System.out.println(nbCustomer);
        model.addAttribute("searchFirstName", firstName);
        model.addAttribute("searchLastName", lastName);
        model.addAttribute("allCustomer", customers);
        model.addAttribute("nbCustomer", nbCustomer);
        return "customer/customers";
    }

    @GetMapping("/{id}")
    public String getCountry(Model model, @PathVariable Long id){

        Optional<Customer> customer=customerService.getCustomerDetailById(id);

        model.addAttribute("customer", customer.get());

        return "customer/detail";

    }

}
