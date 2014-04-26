/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.test.repository;

import com.alex.libraryweb.app.conf.ConnectionConfig;
import com.alex.libraryweb.domain.Inventory;
import com.alex.libraryweb.repository.InventoryRepository;
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
public class InventoryRepositoryTest {
    
    public static ApplicationContext ctx;
    private final Long id = 2L;
    
    private InventoryRepository repo;
    
    public InventoryRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createInventory() {
        
        repo = ctx.getBean(InventoryRepository.class);
        
        Inventory inventory = new Inventory.InventoryBuilder(id)
                .typeOfMaterial("Journal")
                .build();
        
        repo.save(inventory);
        inventory.getId();
        Assert.assertNotNull(inventory);
    }
    
    @Test(dependsOnMethods = "createInventory")
     public void readInventory(){
         repo = ctx.getBean(InventoryRepository.class);
         Inventory inventory = repo.findOne(id);
         Assert.assertEquals(inventory.getTypeOfMaterial(), "Journal");         
     }
     
    @Test(dependsOnMethods = "readInventory")
     private void updateInventory(){
         repo = ctx.getBean(InventoryRepository.class);
         Inventory inventory = repo.findOne(id);
         
         Inventory newInventory = new Inventory.InventoryBuilder(id).inventory(inventory).typeOfMaterial("Magazine").build();
         repo.save(newInventory);
         
         Inventory updateInventory = repo.findOne(id);
         Assert.assertEquals(updateInventory.getTypeOfMaterial(),"Magazine");       
     }
     
    @Test(dependsOnMethods = "updateInventory")
     private void deleteInventory(){
         repo = ctx.getBean(InventoryRepository.class);
         Inventory inventory = repo.findOne(id);
         repo.delete(inventory);
         
         Inventory deletedInventory = repo.findOne(id);
         
         Assert.assertNull(deletedInventory);        
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
