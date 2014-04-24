/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Alex
 */
@Entity
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeOfMaterial;

    public Inventory() {
    }

    public Inventory(InventoryBuilder builder) {
        this.id = builder.id;
        this.typeOfMaterial = builder.typeOfMaterial;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }   

    public Long getId() {
        return id;
    }

    public static class InventoryBuilder{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String typeOfMaterial;

        public InventoryBuilder(Long id) {
            this.id = id;
        }

        public InventoryBuilder typeOfMaterial(String typeOfMaterial) {
            this.typeOfMaterial = typeOfMaterial;
            return this;
        }
        
        public InventoryBuilder inventory(Inventory inven){
            id = inven.getId();
            typeOfMaterial = inven.getTypeOfMaterial();
            return this;
        }
        
        public Inventory build(){
            return new Inventory(this);
        }
        
        
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alex.libraryweb.domain.Inventory[ id=" + id + " ]";
    }
    
}
