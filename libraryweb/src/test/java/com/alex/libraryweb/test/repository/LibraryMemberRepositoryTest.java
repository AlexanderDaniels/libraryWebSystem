/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.Contact;
import com.alex.libraryweb.domain.LibraryMember;
import com.alex.libraryweb.repository.LibraryMemberRepository;
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
public class LibraryMemberRepositoryTest {
    
    public static ApplicationContext ctx;
    private final Long id;
    
    private LibraryMemberRepository repo;
    
    public LibraryMemberRepositoryTest() {
        this.id = 8L;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createLibraryMember() {
        
        repo = ctx.getBean(LibraryMemberRepository.class);
        
        Contact contact = new Contact.ContactBuilder()
                .landline("021 952 0501")
                .address("12 Weber Close, Belhar")
                .cell("074 440 2606")
                .build();
        LibraryMember librarianMem = new LibraryMember.LibraryMemberBuilder(id)
                .membershipNum("123AD")
                .firstName("Alexander")
                .lastName("Daniels")
                .contact(contact)
                .build();
        
        repo.save(librarianMem);
        librarianMem.getId();
        Assert.assertNotNull(librarianMem);
    }
    
    @Test(dependsOnMethods = "createLibraryMember")
     public void readLibraryMember(){
         repo = ctx.getBean(LibraryMemberRepository.class);
         LibraryMember libMem = repo.findOne(id);
         Assert.assertEquals(libMem.getFirstName(), "Alexander");
     }
     
    @Test(dependsOnMethods = "readLibraryMember")
     private void updateLibraryMember(){
         repo = ctx.getBean(LibraryMemberRepository.class);
         LibraryMember librarianMember = repo.findOne(id);
         
         LibraryMember newLibraryMember = new LibraryMember.LibraryMemberBuilder(id).librarianMember(librarianMember).lastName("Daniel").build();
         repo.save(newLibraryMember);
         
         LibraryMember updateLibraryMember = repo.findOne(id);
         Assert.assertEquals(updateLibraryMember.getLastName(), "Daniel");       
     }
     
    @Test(dependsOnMethods = "updateLibraryMember")
     private void deleteLibraryMember(){
         repo = ctx.getBean(LibraryMemberRepository.class);
         LibraryMember librarianMember = repo.findOne(id);
         repo.delete(librarianMember);
         
         LibraryMember deletedLibraryMember = repo.findOne(id);
         
         Assert.assertNull(deletedLibraryMember);        
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
