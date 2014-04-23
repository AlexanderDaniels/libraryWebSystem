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
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String authorCode;
    
    @Embedded
    private Contact contact;
    
    @Embedded
    private Names name;
    
    @Embedded
    private Demographics demo;

    public Author() {
    }    

    public Author(AuthorBuilder builder) {
        this.id = builder.id;
        this.authorCode = builder.authorCode;
        this.contact = builder.contact;
        this.name = builder.name;
        this.demo = builder.demo;
    }      

    public Long getId() {
        return id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAuthorCode() {
        return authorCode;
    }

    public Contact getContact() {
        return contact;
    }

    public Names getName() {
        return name;
    }

    public Demographics getDemo() {
        return demo;
    }
    
    public static class AuthorBuilder{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String authorCode;
    
        @Embedded
        private Contact contact;
    
        @Embedded
        private Names name;
    
        @Embedded
        private Demographics demo;

        public AuthorBuilder(Long id) {
            this.id = id;
        }
        
        public AuthorBuilder authorCode(String authorCode){
            this.authorCode = authorCode;
            return this;
        }
        
        public AuthorBuilder contact(Contact contact){
            this.contact = contact;
            return this;
        }
        
        public AuthorBuilder name(Names name){
            this.name = name;
            return this;
        }
        
        public AuthorBuilder demo(Demographics demo){
            this.demo = demo;
            return this;
        }
        
        public AuthorBuilder author(Author author){
            id = author.getId();
            authorCode = author.getAuthorCode();
            contact = author.getContact();
            name = author.getName();
            demo = author.getDemo();
            
            return this;
        }
        
        public Author build(){
            return new Author(this);
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
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alex.libraryweb.domain.Author[ id=" + id + " ]";
    }
    
}
