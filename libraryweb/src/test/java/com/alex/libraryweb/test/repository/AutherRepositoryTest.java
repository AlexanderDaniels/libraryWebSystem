/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.Author;
import com.alex.libraryweb.domain.Contact;
import com.alex.libraryweb.domain.Demographics;
import com.alex.libraryweb.domain.Names;
import com.alex.libraryweb.repository.AuthorRepository;
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
public class AutherRepositoryTest {
    
    public static ApplicationContext ctx;
    private final Long id = 2L;
    
    private AuthorRepository repo;
    
    public AutherRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createAuthor() {
        
        repo = ctx.getBean(AuthorRepository.class);
        
        Contact contact = new Contact.ContactBuilder()
                .landline("021 952 0501")
                .address("12 Weber Close, Belhar")
                .cell("074 440 2606")
                .build();
        
        Names name = new Names.NamesBuilder()
                .firstName("Eugene")
                .lastName("Daniels")
                .build();
        
        Demographics demo = new Demographics.DemographicsBuilder()
                .gender("Male")
                .race("Coloured")
                .build();
        
        Author author = new Author.AuthorBuilder(id)
                .authorCode("ED123")
                .contact(contact)
                .name(name)
                .demo(demo)
                .build();
                
        
        repo.save(author);
        author.getId();
        Assert.assertNotNull(author);
    }
    
    @Test(dependsOnMethods = "createAuthor")
     public void readAuthor(){
         repo = ctx.getBean(AuthorRepository.class);
         Author author = repo.findOne(id);
         Assert.assertEquals(author.getAuthorCode(), "ED123");         
     }
     
    @Test(dependsOnMethods = "readAuthor")
     private void updateAuthor(){
         repo = ctx.getBean(AuthorRepository.class);
         Author author = repo.findOne(id);
         
         Author newAuthor = new Author.AuthorBuilder(id).author(author).authorCode("ED159").build();
         repo.save(newAuthor);
         
         Author updateAuthor = repo.findOne(id);
         Assert.assertEquals(updateAuthor.getAuthorCode(), "ED159");       
     }
     
    @Test(dependsOnMethods = "updateAuthor")
     private void deleteAuthor(){
         repo = ctx.getBean(AuthorRepository.class);
         Author author = repo.findOne(id);
         repo.delete(author);
         
         Author deletedAuthor = repo.findOne(id);
         
         Assert.assertNull(deletedAuthor);        
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
