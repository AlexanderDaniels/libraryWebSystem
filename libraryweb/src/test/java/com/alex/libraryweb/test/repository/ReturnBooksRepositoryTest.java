/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.ReturnBooks;
import com.alex.libraryweb.repository.ReturnBooksRepository;
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
public class ReturnBooksRepositoryTest {
    
    public static ApplicationContext ctx;
    private final Long id = 1L;
    
    private ReturnBooksRepository repo;
    
    public ReturnBooksRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createReturnBooks() {
        
        repo = ctx.getBean(ReturnBooksRepository.class);
        
        ReturnBooks returnBooks = new ReturnBooks.ReturnBooksBuilder(id)
                .bookName("Amazing Alex")
                .isbnNumber("AA 123 456")
                .build();              
        
        repo.save(returnBooks);
        returnBooks.getId();
        Assert.assertNotNull(returnBooks);
    }
    
    @Test(dependsOnMethods = "createReturnBooks")
     public void readReturnBooks(){
         repo = ctx.getBean(ReturnBooksRepository.class);
         ReturnBooks returnBooks = repo.findOne(id);
         Assert.assertEquals(returnBooks.getBookName(), "Amazing Alex");         
     }
     
    @Test(dependsOnMethods = "readReturnBooks")
     private void updateReturnBooks(){
         repo = ctx.getBean(ReturnBooksRepository.class);
         ReturnBooks returnBooks = repo.findOne(id);
         
         ReturnBooks newReturnBooks = new ReturnBooks.ReturnBooksBuilder(id).returnBooks(returnBooks).bookName("The Amazing Alex").build();
         repo.save(newReturnBooks);
         
         ReturnBooks updateReturnBooks = repo.findOne(id);
         Assert.assertEquals(updateReturnBooks.getBookName(),"The Amazing Alex");       
     }
     
    @Test(dependsOnMethods = "updateReturnBooks")
     private void deleteReturnBooks(){
         repo = ctx.getBean(ReturnBooksRepository.class);
         ReturnBooks returnBooks = repo.findOne(id);
         repo.delete(returnBooks);
         
         ReturnBooks deletedReturnBooks = repo.findOne(id);
         
         Assert.assertNull(deletedReturnBooks);        
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
