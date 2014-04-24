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
public class BuyBooks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double bookPrice;

    public BuyBooks() {
    }

    public BuyBooks(BuyBooksBuilder builder) {
        this.id = builder.id;
        this.bookPrice = builder.bookPrice;
    }        

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public double getBookPrice() {
        return bookPrice;
    }   

    public Long getId() {
        return id;
    }
    
    public static class BuyBooksBuilder{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private double bookPrice;

        public BuyBooksBuilder(Long id) {
            this.id = id;
        }

        public BuyBooksBuilder bookPrice(double bookPrice) {
            this.bookPrice = bookPrice;
            return this;
        }
        
        public BuyBooksBuilder buyBooks(BuyBooks buyBooks){
            id = buyBooks.getId();
            bookPrice = buyBooks.getBookPrice();
            
            return this;
        }
        
        public BuyBooks build(){
            return new BuyBooks(this);
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
        if (!(object instanceof BuyBooks)) {
            return false;
        }
        BuyBooks other = (BuyBooks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alex.libraryweb.domain.BuyBooks[ id=" + id + " ]";
    }
    
}
