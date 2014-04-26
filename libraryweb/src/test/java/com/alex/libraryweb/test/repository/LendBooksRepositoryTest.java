/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.LendBooks;
import com.alex.libraryweb.repository.LendBooksRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class LendBooksRepositoryTest {
    
    public static ApplicationContext ctx;
    private final Long id = 1L;
    
    private LendBooksRepository repo;
    
    public LendBooksRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    /*@Test
    public void createBuyBooks() {
        
        repo = ctx.getBean(LendBooksRepository.class);
        
        LendBooks lendBooks = new LendBooks.
        
        repo.save(buyBooks);
        buyBooks.getId();
        Assert.assertNotNull(buyBooks);
    }
    
    @Test(dependsOnMethods = "createBuyBooks")
     public void readBuyBooks(){
         repo = ctx.getBean(BuyBooksRepository.class);
         BuyBooks buyBooks = repo.findOne(id);
         Assert.assertEquals(buyBooks.getBookPrice(), 200.00);         
     }
     
    @Test(dependsOnMethods = "readBuyBooks")
     private void updateBuyBooks(){
         repo = ctx.getBean(BuyBooksRepository.class);
         BuyBooks buyBooks = repo.findOne(id);
         
         BuyBooks newBuyBooks = new BuyBooks.BuyBooksBuilder(id).buyBooks(buyBooks).bookPrice(2000.00).build();
         repo.save(newBuyBooks);
         
         BuyBooks updateBuyBooks = repo.findOne(id);
         Assert.assertEquals(updateBuyBooks.getBookPrice(),2000.00);       
     }
     
    @Test(dependsOnMethods = "updateBuyBooks")
     private void deleteBuyBooks(){
         repo = ctx.getBean(BuyBooksRepository.class);
         BuyBooks buyBooks = repo.findOne(id);
         repo.delete(buyBooks);
         
         BuyBooks deletedBuyBooks = repo.findOne(id);
         
         Assert.assertNull(deletedBuyBooks);        
     }*/

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
