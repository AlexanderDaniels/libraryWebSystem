/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.PayBill;
import com.alex.libraryweb.repository.PayBillRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Alex
 */
public class PayBillRpeositoryTest {
    
    public static ApplicationContext ctx;
    private final Long id = 1L;
    
    private PayBillRepository repo;
    
    public PayBillRpeositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createPayBill() {
        
        repo = ctx.getBean(PayBillRepository.class);
        
        PayBill payBill = new PayBill.PayBillBuilder(id)
                .billNo("ASD1")
                .amount(200.00)
                .build();
        
        repo.save(payBill);
        payBill.getId();
        Assert.assertNotNull(payBill);
    }
    
    @Test(dependsOnMethods = "createPayBill")
     public void readPayBill(){
         repo = ctx.getBean(PayBillRepository.class);
         PayBill payBill = repo.findOne(id);
         Assert.assertEquals(payBill.getAmount(), 200.00);         
     }
     
    @Test(dependsOnMethods = "readPayBill")
     private void updatePayBill(){
         repo = ctx.getBean(PayBillRepository.class);
         PayBill payBill = repo.findOne(id);
         
         PayBill newPayBill = new PayBill.PayBillBuilder(id).payBill(payBill).amount(150.99).build();
         repo.save(newPayBill);
         
         PayBill updatePayBill = repo.findOne(id);
         Assert.assertEquals(updatePayBill.getAmount(),150.99);       
     }
     
    @Test(dependsOnMethods = "updatePayBill")
     private void deletePayBill(){
         repo = ctx.getBean(PayBillRepository.class);
         PayBill buyBooks = repo.findOne(id);
         repo.delete(buyBooks);
         
         PayBill deletedBuyBooks = repo.findOne(id);
         
         Assert.assertNull(deletedBuyBooks);        
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
