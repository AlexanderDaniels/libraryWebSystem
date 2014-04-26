/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.Salary;
import com.alex.libraryweb.repository.SalaryRepository;
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
public class SalaryRepositoryTest {
    
    public static ApplicationContext ctx;
    private final Long id = 1L;
    
    private SalaryRepository repo;
    
    public SalaryRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createSalary() {
        
        repo = ctx.getBean(SalaryRepository.class);
        
        Salary salary = new Salary.SalaryBuilder(id)
                .annualSalary(100000.00)
                .build();              
        
        repo.save(salary);
        salary.getId();
        Assert.assertNotNull(salary);
    }
    
    @Test(dependsOnMethods = "createSalary")
     public void readSalary(){
         repo = ctx.getBean(SalaryRepository.class);
         Salary salary = repo.findOne(id);
         Assert.assertEquals(salary.getAnnualSalary(), 100000.00);         
     }
     
    @Test(dependsOnMethods = "readSalary")
     private void updateSalary(){
         repo = ctx.getBean(SalaryRepository.class);
         Salary salary = repo.findOne(id);
         
         Salary newBuyBooks = new Salary.SalaryBuilder(id).salary(salary).annualSalary(150000.00).build();
         repo.save(newBuyBooks);
         
         Salary updateSalary = repo.findOne(id);
         Assert.assertEquals(updateSalary.getAnnualSalary(),150000.00);       
     }
     
    @Test(dependsOnMethods = "updateSalary")
     private void deleteSalary(){
         repo = ctx.getBean(SalaryRepository.class);
         Salary buyBooks = repo.findOne(id);
         repo.delete(buyBooks);
         
         Salary deletedBuyBooks = repo.findOne(id);
         
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
