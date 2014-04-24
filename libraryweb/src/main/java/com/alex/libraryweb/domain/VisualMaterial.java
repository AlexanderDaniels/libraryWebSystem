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
public class VisualMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeOfVisualMaterial;
    private String nameOfVisualMaterial;

    public VisualMaterial() {
    }

    public VisualMaterial(VisualMaterialBuilder builder) {
        this.id = builder.id;
        this.typeOfVisualMaterial = builder.typeOfVisualMaterial;
        this.nameOfVisualMaterial = builder.nameOfVisualMaterial;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTypeOfVisualMaterial() {
        return typeOfVisualMaterial;
    }

    public String getNameOfVisualMaterial() {
        return nameOfVisualMaterial;
    }    

    public Long getId() {
        return id;
    }
    
    public static class VisualMaterialBuilder{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String typeOfVisualMaterial;
        private String nameOfVisualMaterial;

        public VisualMaterialBuilder(Long id) {
            this.id = id;
        }
        
        public VisualMaterialBuilder typeOfVisualMaterial(String typeOfVisualMaterial) {
            this.typeOfVisualMaterial = typeOfVisualMaterial;
            return this;
        }

        public VisualMaterialBuilder nameOfVisualMaterial(String nameOfVisualMaterial) {
            this.nameOfVisualMaterial = nameOfVisualMaterial;
            return this;
        }
        
        public VisualMaterialBuilder visualMaterial(VisualMaterial visualMaterial){
            id = visualMaterial.getId();
            typeOfVisualMaterial = visualMaterial.getTypeOfVisualMaterial();
            nameOfVisualMaterial = visualMaterial.getNameOfVisualMaterial();
            
            return this;
        }
        
        public VisualMaterial build(){
            return new VisualMaterial(this);
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
        if (!(object instanceof VisualMaterial)) {
            return false;
        }
        VisualMaterial other = (VisualMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alex.libraryweb.domain.VisualMaterial[ id=" + id + " ]";
    }
    
}
