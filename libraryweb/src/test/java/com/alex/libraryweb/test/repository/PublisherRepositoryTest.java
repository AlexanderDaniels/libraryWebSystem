/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.Contact;
import com.alex.libraryweb.domain.Publisher;
import com.alex.libraryweb.repository.PublisherRepository;
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
public class PublisherRepositoryTest {
    
    public static ApplicationContext ctx;
    private final Long id = 1L;
    
    private PublisherRepository repo;
    
    public PublisherRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createPublisher() {
        
        repo = ctx.getBean(PublisherRepository.class);
        
        Contact contact = new Contact.ContactBuilder()
                .address("15 Akker Street")
                .cell("074 440 2606")
                .landline("021 685 5189")
                .build();                
        
        Publisher publisher = new Publisher.PublisherBuilder(id)
                .publisherName("Readers Bound")
                .contact(contact)
                .build();
        
        repo.save(publisher);
        publisher.getId();
        Assert.assertNotNull(publisher);
    }
    
    @Test(dependsOnMethods = "createPublisher")
     public void readPublisher(){
         repo = ctx.getBean(PublisherRepository.class);
         Publisher publisher = repo.findOne(id);
         Assert.assertEquals(publisher.getPublisherName(), "Readers Bound");         
     }
     
    @Test(dependsOnMethods = "readPublisher")
     private void updatePublisher(){
         repo = ctx.getBean(PublisherRepository.class);
         Publisher publisher = repo.findOne(id);
         
         Publisher newPublisher = new Publisher.PublisherBuilder(id).publisher(publisher).publisherName("ILoveToRead").build();
         repo.save(newPublisher);
         
         Publisher updatePublisher = repo.findOne(id);
         Assert.assertEquals(updatePublisher.getPublisherName(),"ILoveToRead");       
     }
     
    @Test(dependsOnMethods = "updatePublisher")
     private void deletePublisher(){
         repo = ctx.getBean(PublisherRepository.class);
         Publisher publisher = repo.findOne(id);
         repo.delete(publisher);
         
         Publisher deletedPublisher = repo.findOne(id);
         
         Assert.assertNull(deletedPublisher);        
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
