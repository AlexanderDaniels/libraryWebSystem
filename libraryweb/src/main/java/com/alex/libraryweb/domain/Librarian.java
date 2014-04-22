/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.domain;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Alex
 */
@Entity
public class Librarian implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    
    @Embedded
    private Contact contact;

    public Librarian() {
    }

    public Librarian(LibrarianBuilder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contact = builder.contact;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public static class LibrarianBuilder{
        private Long id;
        private String firstName;
        private String lastName;
    
        @Embedded
        private Contact contact;

        public LibrarianBuilder(Long id) {
            this.id = id;
        }
        
        public LibrarianBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        
        public LibrarianBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        
        public LibrarianBuilder contact(Contact contact){
            this.contact = contact;
            return this;
        }
        
        public LibrarianBuilder librarian(Librarian lib){
            id = lib.getId();
            firstName = lib.getFirstName();
            lastName = lib.getLastName();
            contact = lib.getContact();
            return this;
        }
        
        public Librarian build(){
            return new Librarian(this);
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
        if (!(object instanceof Librarian)) {
            return false;
        }
        Librarian other = (Librarian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tp.alex.libraryweb.domain.Librarian[ id=" + id + " ]";
    }
    
}
