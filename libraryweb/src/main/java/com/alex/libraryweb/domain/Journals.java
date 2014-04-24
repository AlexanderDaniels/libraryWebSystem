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
public class Journals implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String journalName;
    private int numOfPages;

    public Journals() {
    }

    public Journals(JournalsBuilder builder) {
        this.id = builder.id;
        this.journalName = builder.journalName;
        this.numOfPages = builder.numOfPages;
    }
    
    public Long getId() {
        return id;
    }   

    public String getJournalName() {
        return journalName;
    }

    public int getNumOfPages() {
        return numOfPages;
    }
    
    public static class JournalsBuilder{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String journalName;
        private int numOfPages;

        public JournalsBuilder(Long id) {
            this.id = id;
        }   

        public JournalsBuilder journalName(String journalName) {
            this.journalName = journalName;
            return this;
        }

        public JournalsBuilder numOfPages(int numOfPages) {
            this.numOfPages = numOfPages;
            return this;
        }
        
        public JournalsBuilder journals(Journals journals){
            id = journals.getId();
            journalName = journals.getJournalName();
            numOfPages = journals.getNumOfPages();
            
            return this;
        }
        
        public Journals build(){
            return new Journals(this);
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
        if (!(object instanceof Journals)) {
            return false;
        }
        Journals other = (Journals) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alex.libraryweb.domain.Journals[ id=" + id + " ]";
    }
    
}
