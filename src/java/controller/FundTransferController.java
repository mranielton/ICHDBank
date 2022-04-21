/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import ICHDApp.Account;
import ICHDApp.FundTransfer;
import TransferFund.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author Espi
 */
@Controller
@RequestMapping(value="/fundtransfer.htm")
public class FundTransferController {
    private ValidatingFundTransfer validatingFundTransfer;
    
    @RequestMapping(method=RequestMethod.GET)
    public String showLoginView(ModelMap model)
    {
        FundTransfer ft = new FundTransfer();
        model.addAttribute("transferaccount", ft);
        return "fundtransfer";
    }
    @RequestMapping(method=RequestMethod.POST)
    public String processForm(@ModelAttribute(value="transferaccount")FundTransfer act,ModelMap model)
    {
        String message="";
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ICHDApp/Spring-Config.xml");
        FundTransferApp ft = (FundTransferApp)ctx.getBean("transferProxy");
        Account acc = (Account)ctx.getBean("AccountBean");
        ft.transferAmount(act.getTransactionPassword(),act.getToAccount(),act.getAmount(),acc.getBalance());
        if(ValidatingFundTransfer.staticPasswordStatus.compareTo("Valid")==0)
        {
            if(ValidatingFundTransfer.staticPasswordStatus.compareTo("IllegalValue")==0)
            {
                message = "You don't have Sufficient Funds";
            }
            else
            {
               message = "Transaction Successful";
               message = message+" <p>Amount of $"+act.getAmount()+" has been transferred. Your current balance is: $"+ValidatingFundTransfer.staticNewBalanceStatus;
            }
        }
        else
        {
            message = "You have entered Invalid Transaction password";
        }
        model.addAttribute("message",message);
        return "transfer";
    }
    /**
     * 
     * @param validatingFundTransfer the validatingFundTransfer to set
     */
    
    public void setValidatingFundTransfer(ValidatingFundTransfer validatingFundTransfer)
    {
        this.validatingFundTransfer = validatingFundTransfer;
    }
}
