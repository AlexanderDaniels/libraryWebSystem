/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.Journals;
import com.alex.libraryweb.repository.JournalsRepository;
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
public class JournalsRepositoryTest {
    
    public static ApplicationContext ctx;
    private final Long id = 2L;
    
    private JournalsRepository repo;
    
    public JournalsRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createJournals() {
        
        repo = ctx.getBean(JournalsRepository.class);
        
        Journals journals = new Journals.JournalsBuilder(id)
                .journalName("Top 20 journals")
                .numOfPages(10)
                .build();
        
        repo.save(journals);
        journals.getId();
        Assert.assertNotNull(journals);
    }
    
    @Test(dependsOnMethods = "createJournals")
     public void readJournals(){
         repo = ctx.getBean(JournalsRepository.class);
         Journals journals = repo.findOne(id);
         Assert.assertEquals(journals.getNumOfPages(), 10);         
     }
     
    @Test(dependsOnMethods = "readJournals")
     private void updateJournals(){
         repo = ctx.getBean(JournalsRepository.class);
         Journals journals = repo.findOne(id);
         
         Journals newJournals = new Journals.JournalsBuilder(id).journals(journals).numOfPages(11).build();
         repo.save(newJournals);
         
         Journals updateJournals = repo.findOne(id);
         Assert.assertEquals(updateJournals.getNumOfPages(),11);       
     }
     
    @Test(dependsOnMethods = "updateJournals")
     private void deleteJournals(){
         repo = ctx.getBean(JournalsRepository.class);
         Journals journals = repo.findOne(id);
         repo.delete(journals);
         
         Journals deletedJournals = repo.findOne(id);
         
         Assert.assertNull(deletedJournals);        
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
