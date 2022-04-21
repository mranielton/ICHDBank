/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import ICHDApp.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.*;

@Controller
@RequestMapping(value="/loginView.htm")
/**
 *
 * @author Espi
 */
public class LoginController {
    LoginService loginService;
    
    public void setLoginService(LoginService loginService)
    {
        this.loginService = loginService;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String showLoginView(ModelMap model)
    {
        Customer customer = new Customer();
        model.addAttribute("CUSTOMER", customer);
        return "loginView";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String processForm(@ModelAttribute(value="CUSTOMER") Customer customer,ModelMap model)
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ICHDApp/Spring-Config.xml");
        Account act = (Account)ac.getBean("AccountBean");
        String str ="Account Number: "+act.getAccountNumber();
        model.addAttribute("accountNumber",str);
        String str1 = "Account Balance ($): "+act.getBalance();
        model.addAttribute("accountBalance", str1);
        model.addAttribute("helloMessage", loginService.sayHello(customer.getUsername()));
        
        return "userAccount";
    }   
}
