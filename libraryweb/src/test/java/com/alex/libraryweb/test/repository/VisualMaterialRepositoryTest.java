/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.VisualMaterial;
import com.alex.libraryweb.repository.VisualMaterialRepository;
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
public class VisualMaterialRepositoryTest {
    
    public static ApplicationContext ctx;
    private final Long id = 1L;
    
    private VisualMaterialRepository repo;
    
    public VisualMaterialRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createVisualMaterial() {
        
        repo = ctx.getBean(VisualMaterialRepository.class);
        
        VisualMaterial visualMaterial = new VisualMaterial.VisualMaterialBuilder(id)
                .nameOfVisualMaterial("Ice Age 3")
                .typeOfVisualMaterial("DVD")
                .build();              
        
        repo.save(visualMaterial);
        visualMaterial.getId();
        Assert.assertNotNull(visualMaterial);
    }
    
    @Test(dependsOnMethods = "createVisualMaterial")
     public void readVisualMaterial(){
         repo = ctx.getBean(VisualMaterialRepository.class);
         VisualMaterial visualMaterial = repo.findOne(id);
         Assert.assertEquals(visualMaterial.getTypeOfVisualMaterial(), "DVD");         
     }
     
    @Test(dependsOnMethods = "readVisualMaterial")
     private void updateVisualMaterial(){
         repo = ctx.getBean(VisualMaterialRepository.class);
         VisualMaterial visualMaterial = repo.findOne(id);
         
         VisualMaterial newVisualMaterial = new VisualMaterial.VisualMaterialBuilder(id).visualMaterial(visualMaterial).typeOfVisualMaterial("Blu-Ray").build();
         repo.save(newVisualMaterial);
         
         VisualMaterial updateVisualMaterial = repo.findOne(id);
         Assert.assertEquals(updateVisualMaterial.getTypeOfVisualMaterial(),"Blu-Ray");       
     }
     
    @Test(dependsOnMethods = "updateVisualMaterial")
     private void deleteVisualMaterial(){
         repo = ctx.getBean(VisualMaterialRepository.class);
         VisualMaterial visualMaterial = repo.findOne(id);
         repo.delete(visualMaterial);
         
         VisualMaterial deletedVisualMaterial = repo.findOne(id);
         
         Assert.assertNull(deletedVisualMaterial);        
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
