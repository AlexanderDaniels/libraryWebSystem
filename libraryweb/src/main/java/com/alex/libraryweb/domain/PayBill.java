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
public class PayBill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String billNo;
    private double amount;

    public PayBill() {
    }

    public PayBill(PayBillBuilder builder) {
        this.id = builder.id;
        this.billNo = builder.billNo;
        this.amount = builder.amount;
    }

    public Long getId() {
        return id;
    }

    public String getBillNo() {
        return billNo;
    }

    public double getAmount() {
        return amount;
    }
    
    public static class PayBillBuilder{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String billNo;
        private double amount;

        public PayBillBuilder(Long id) {
            this.id = id;
        }
        
        public PayBillBuilder billNo(String billNo) {
            this.billNo = billNo;
            return this;
        }

        public PayBillBuilder amount(double amount) {
            this.amount = amount;
            return this;
        }
        
        public PayBillBuilder payBill(PayBill payBill){
            id = payBill.getId();
            billNo = payBill.getBillNo();
            amount = payBill.getAmount();
            
            return this;
        }
        
        public PayBill build(){
            return new PayBill(this);
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
        if (!(object instanceof PayBill)) {
            return false;
        }
        PayBill other = (PayBill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alex.libraryweb.domain.PayBill[ id=" + id + " ]";
    }
    
}
