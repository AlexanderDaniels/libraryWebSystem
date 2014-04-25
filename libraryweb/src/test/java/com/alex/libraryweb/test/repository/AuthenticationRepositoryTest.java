/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.Authentication;
import com.alex.libraryweb.repository.AuthenticationRepository;
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
public class AuthenticationRepositoryTest {
    
    public static ApplicationContext ctx;
    private final Long id = 2L;
    
    private AuthenticationRepository repo;
    
    public AuthenticationRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createAuthentication() {
        
        repo = ctx.getBean(AuthenticationRepository.class);
        
        Authentication auth = new Authentication.AuthenticationBuilder(id)
                .username("Alex123")
                .password("qwerty")
                .build();
                
        
        repo.save(auth);
        auth.getId();
        Assert.assertNotNull(auth);
    }
    
    @Test(dependsOnMethods = "createAuthentication")
     public void readAuthentication(){
         repo = ctx.getBean(AuthenticationRepository.class);
         Authentication auth = repo.findOne(id);
         Assert.assertEquals(auth.getPassword(), "qwerty");         
     }
     
    @Test(dependsOnMethods = "readAuthentication")
     private void updateAuthentication(){
         repo = ctx.getBean(AuthenticationRepository.class);
         Authentication auth = repo.findOne(id);
         
         Authentication newAuth = new Authentication.AuthenticationBuilder(id).authentication(auth).password("123Alex").build();
         repo.save(newAuth);
         
         Authentication updateAuth = repo.findOne(id);
         Assert.assertEquals(updateAuth.getPassword(), "123Alex");       
     }
     
    @Test(dependsOnMethods = "updateAuthentication")
     private void deleteAuthentication(){
         repo = ctx.getBean(AuthenticationRepository.class);
         Authentication auth = repo.findOne(id);
         repo.delete(auth);
         
         Authentication deletedAuth = repo.findOne(id);
         
         Assert.assertNull(deletedAuth);        
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
