/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ICHDApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 *
 * @author Espi
 */
public class TestBeanWiring {
    public static void main(String s[])
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ICHDApp/Spring-Config.xml");
        Customer cust = (Customer)ac.getBean("CustomerBean");
        System.out.println("The Values are: ");
        System.out.println(cust.getFirstName());
        System.out.println(cust.getMiddleName());
        System.out.println(cust.getLastName());
    }
}
