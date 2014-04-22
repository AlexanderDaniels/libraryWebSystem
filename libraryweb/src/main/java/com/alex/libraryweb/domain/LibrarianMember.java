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
public class LibrarianMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String membershipNum;
    private String firstName;
    private String lastName;
    
    @Embedded
    private Contact contact;

    public LibrarianMember() {
    }  

    public LibrarianMember(LibrarianMemberBuilder builder) {
        this.id = builder.id;
        this.membershipNum = builder.membershipNum;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contact = builder.contact;
    }    

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMembershipNum() {
        return membershipNum;
    }

    public Contact getContact() {
        return contact;
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
    
    
    
    public static class LibrarianMemberBuilder{
        private Long id;
        private String membershipNum;
        private String firstName;
        private String lastName;
    
        @Embedded
        private Contact contact;

        public LibrarianMemberBuilder(Long id) {
            this.id = id;
        }
        
        public LibrarianMemberBuilder membershipNum(String membershipNum){
            this.membershipNum = membershipNum;
            return this;
        }
        
        public LibrarianMemberBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        
        public LibrarianMemberBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        
        public LibrarianMemberBuilder contact(Contact contact){
            this.contact = contact;
            return this;
        }
        
        public LibrarianMemberBuilder librarianMember(LibrarianMember libMember){
            id = libMember.getId();
            membershipNum = libMember.getMembershipNum();
            firstName = libMember.getFirstName();
            lastName = libMember.getLastName();
            contact = libMember.getContact();
            return this;
        }
        
        public LibrarianMember build(){
            return new LibrarianMember(this);
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
        if (!(object instanceof LibrarianMember)) {
            return false;
        }
        LibrarianMember other = (LibrarianMember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alex.libraryweb.domain.LibrarianMember[ id=" + id + " ]";
    }
    
}
