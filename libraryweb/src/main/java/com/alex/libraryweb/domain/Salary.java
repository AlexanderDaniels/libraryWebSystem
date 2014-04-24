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
public class Salary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double annualSalary;

    public Salary() {
    }

    public Salary(SalaryBuilder builder) {
        this.id = builder.id;
        this.annualSalary = builder.annualSalary;
    }       

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }
    
    public Long getId() {
        return id;
    }

    public static class SalaryBuilder{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private double annualSalary;

        public SalaryBuilder(Long id) {
            this.id = id;
        }

        public SalaryBuilder annualSalary(double annualSalary) {
            this.annualSalary = annualSalary;
            return this;
        }
        
        public SalaryBuilder salary(Salary sal){
            id = sal.getId();
            annualSalary = sal.getAnnualSalary();
            return this;
        }
        
        public Salary build(){
            return new Salary(this);
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
        if (!(object instanceof Salary)) {
            return false;
        }
        Salary other = (Salary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alex.libraryweb.domain.Salary[ id=" + id + " ]";
    }
    
}
