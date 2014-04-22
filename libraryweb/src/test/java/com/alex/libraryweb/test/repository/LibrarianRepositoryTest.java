/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.Contact;
import com.alex.libraryweb.domain.Librarian;
import com.alex.libraryweb.repository.LibrarianRepository;
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
public class LibrarianRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    
    private LibrarianRepository repo;
    
    public LibrarianRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createLibrarian() {
        
        repo = ctx.getBean(LibrarianRepository.class);
        
        Contact contact = new Contact.ContactBuilder()
                .landline("021 952 0501")
                .address("12 Weber Close, Belhar")
                .cell("074 440 2606")
                .build();
        Librarian librarian = new Librarian.LibrarianBuilder(id)
                .firstName("Alexander")
                .lastName("Daniels")
                .contact(contact)
                .build();
        
        repo.save(librarian);
        librarian.getId();
        Assert.assertNotNull(librarian);
    }
    
    @Test(dependsOnMethods = "createPerson")
     public void readLibrarian(){
         repo = ctx.getBean(LibrarianRepository.class);
         Librarian librarian = repo.findOne(id);
         Assert.assertEquals(librarian.getFirstName(), "Alexander");
         
     }
     
    @Test(dependsOnMethods = "readPerson")
     private void updateLibrarian(){
         repo = ctx.getBean(LibrarianRepository.class);
         Librarian librarian = repo.findOne(id);
         //librarian.
         repo.save(librarian);
         
         Librarian updateLibrarian = repo.findOne(id);
         Assert.assertEquals(updateLibrarian.getFirstName(), "Boniface");
         
     }
     
     @Test(dependsOnMethods = "updatePerson")
     private void deletePerson(){
         repo = ctx.getBean(LibrarianRepository.class);
         Librarian person = repo.findOne(id);
         repo.delete(person);
         
         Librarian deletedPerson = repo.findOne(id);
         
         Assert.assertNull(deletedPerson);
         
         
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
