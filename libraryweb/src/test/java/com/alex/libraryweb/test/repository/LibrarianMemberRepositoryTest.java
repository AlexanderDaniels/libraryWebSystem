/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.Contact;
import com.alex.libraryweb.domain.LibrarianMember;
import com.alex.libraryweb.repository.LibrarianMemberRepository;
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
public class LibrarianMemberRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id = 3L;
    
    private LibrarianMemberRepository repo;
    
    public LibrarianMemberRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createLibrarianMember() {
        
        repo = ctx.getBean(LibrarianMemberRepository.class);
        
        Contact contact = new Contact.ContactBuilder()
                .landline("021 952 0501")
                .address("12 Weber Close, Belhar")
                .cell("074 440 2606")
                .build();
        LibrarianMember librarianMem = new LibrarianMember.LibrarianMemberBuilder(id)
                .membershipNum("123AD")
                .firstName("Alexander")
                .lastName("Daniels")
                .contact(contact)
                .build();
        
        repo.save(librarianMem);
        librarianMem.getId();
        Assert.assertNotNull(librarianMem);
    }
    
    @Test(dependsOnMethods = "createLibrarianMember")
     public void readLibrarianMember(){
         repo = ctx.getBean(LibrarianMemberRepository.class);
         LibrarianMember librarianMem = repo.findOne(id);
         Assert.assertEquals(librarianMem.getFirstName(), "Alexander");         
     }
     
    @Test(dependsOnMethods = "readLibrarianMember")
     private void updateLibrarianMember(){
         repo = ctx.getBean(LibrarianMemberRepository.class);
         LibrarianMember librarianMember = repo.findOne(id);
         
         LibrarianMember newLibrarianMember = new LibrarianMember.LibrarianMemberBuilder(id).librarianMember(librarianMember).lastName("Daniel").build();
         repo.save(newLibrarianMember);
         
         LibrarianMember updateLibrarianMember = repo.findOne(id);
         Assert.assertEquals(updateLibrarianMember.getLastName(), "Daniel");       
     }
     
    @Test(dependsOnMethods = "updateLibrarianMember")
     private void deleteLibrarianMember(){
         repo = ctx.getBean(LibrarianMemberRepository.class);
         LibrarianMember librarianMember = repo.findOne(id);
         repo.delete(librarianMember);
         
         LibrarianMember deletedLibrarianMember = repo.findOne(id);
         
         Assert.assertNull(deletedLibrarianMember);        
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
