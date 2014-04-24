/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Alex
 */
@Entity
public class CalculateFine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date bookHired;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date returnDate;
    
    private double priceOfFine;

    public CalculateFine() {
    }

    public CalculateFine(CalculateFineBuilder builder) {
        this.id = builder.id;
        this.bookHired = builder.bookHired;
        this.returnDate = builder.returnDate;
        this.priceOfFine = builder.priceOfFine;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getBookHired() {
        return bookHired;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public double getPriceOfFine() {
        return priceOfFine;
    }    
    
    public Long getId() {
        return id;
    }
    
    public static class CalculateFineBuilder{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;  
    
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date bookHired;
    
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date returnDate;
    
        private double priceOfFine;

        public CalculateFineBuilder(Long id) {
            this.id = id;
        }

        public CalculateFineBuilder bookHired(Date bookHired) {
            this.bookHired = bookHired;
            return this;
        }

        public CalculateFineBuilder returnDate(Date returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public CalculateFineBuilder priceOfFine(double priceOfFine) {
            this.priceOfFine = priceOfFine;
            return this;
        }
        
        public CalculateFineBuilder calculateFine(CalculateFine calcFine){
            id = calcFine.getId();
            bookHired = calcFine.getBookHired();
            returnDate = calcFine.getReturnDate();
            priceOfFine = calcFine.getPriceOfFine();
            return this;
        }
        
        public CalculateFine build(){
            return new CalculateFine(this);
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
        if (!(object instanceof CalculateFine)) {
            return false;
        }
        CalculateFine other = (CalculateFine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alex.libraryweb.domain.CalculateFine[ id=" + id + " ]";
    }
    
}
