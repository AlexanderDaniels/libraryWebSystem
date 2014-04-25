/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.Books;
import com.alex.libraryweb.repository.BooksRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Alex
 */
public class BooksRepositoryTest {
    
    public static ApplicationContext ctx;
    private final Long id = 2L;
    
    private BooksRepository repo;    
    
    public BooksRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createBooks() {
        
        repo = ctx.getBean(BooksRepository.class);
        
        Books books = new Books.BooksBuilder(id)
                .bookName("Harry Potter")
                .isbnNumber("hp168 68453 6581")
                .build();
                
                
        
        repo.save(books);
        books.getId();
        Assert.assertNotNull(books);
    }
    
    @Test(dependsOnMethods = "createBooks")
     public void readBooks(){
         repo = ctx.getBean(BooksRepository.class);
         Books books = repo.findOne(id);
         Assert.assertEquals(books.getBookName(), "Harry Potter");         
     }
     
    @Test(dependsOnMethods = "readBooks")
     private void updateBooks(){
         repo = ctx.getBean(BooksRepository.class);
         Books books = repo.findOne(id);
         
         Books newBooks = new Books.BooksBuilder(id).books(books).bookName("Amazing Alex").build();
         repo.save(newBooks);
         
         Books updateBooks = repo.findOne(id);
         Assert.assertEquals(updateBooks.getBookName(), "Amazing Alex");       
     }
     
    @Test(dependsOnMethods = "updateBooks")
     private void deleteBooks(){
         repo = ctx.getBean(BooksRepository.class);
         Books books = repo.findOne(id);
         repo.delete(books);
         
         Books deletedBooks = repo.findOne(id);
         
         Assert.assertNull(deletedBooks);        
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
