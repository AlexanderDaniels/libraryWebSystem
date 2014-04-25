/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.CalculateFine;
import com.alex.libraryweb.repository.CalculateFineRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class CalculateFineRepositoryTest {
    
    public static ApplicationContext ctx;
    private final Long id = 1L;
    
    private CalculateFineRepository repo;
    
    public CalculateFineRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createCalculateFine() throws ParseException {
        SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
        String paramDateAsString1 = "2014-01-10";
        String paramDateAsString2 = "2014-01-25";
        Date myDate1 = null;
        Date myDate2 = null;

        myDate1 = textFormat.parse(paramDateAsString1);
        myDate2 = textFormat.parse(paramDateAsString2);
        repo = ctx.getBean(CalculateFineRepository.class);
        
        CalculateFine calculateFine;
        calculateFine = new CalculateFine.CalculateFineBuilder(id)
                .bookHired(myDate1)
                .returnDate(myDate2)
                .priceOfFine(20.00)
                .build();
        
        repo.save(calculateFine);
        calculateFine.getId();
        Assert.assertNotNull(calculateFine);
    }
    
    @Test(dependsOnMethods = "createCalculateFine")
     public void readCalculateFine(){
         repo = ctx.getBean(CalculateFineRepository.class);
         CalculateFine calculateFine = repo.findOne(id);
         Assert.assertEquals(calculateFine.getPriceOfFine(), 20.00);         
     }
     
    @Test(dependsOnMethods = "readCalculateFine")
     private void updateCalculateFine(){
         repo = ctx.getBean(CalculateFineRepository.class);
         CalculateFine calculateFine = repo.findOne(id);
         
         CalculateFine newCalculateFine = new CalculateFine.CalculateFineBuilder(id).priceOfFine(15.00).build();
         repo.save(newCalculateFine);
         
         CalculateFine updateCalculateFine = repo.findOne(id);
         Assert.assertEquals(updateCalculateFine.getPriceOfFine(),15.00);       
     }
     
    @Test(dependsOnMethods = "updateCalculateFine")
     private void deleteCalculateFine(){
         repo = ctx.getBean(CalculateFineRepository.class);
         CalculateFine calculateFine = repo.findOne(id);
         repo.delete(calculateFine);
         
         CalculateFine deletedCalculateFine = repo.findOne(id);
         
         Assert.assertNull(deletedCalculateFine);        
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
