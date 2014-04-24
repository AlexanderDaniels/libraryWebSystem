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
public class Books implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookName;
    private String isbnNumber;

    public Books() {
    }

    public Books(BooksBuilder builder) {
        this.id = builder.id;
        this.bookName = builder.bookName;
        this.isbnNumber = builder.isbnNumber;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBookName() {
        return bookName;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }
    
    public Long getId() {
        return id;
    }
    
    public static class BooksBuilder{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String bookName;
        private String isbnNumber;

        public BooksBuilder(Long id) {
            this.id = id;
        }

        public BooksBuilder bookName(String bookName) {
            this.bookName = bookName;
            return this;
        }

        public BooksBuilder isbnNumber(String isbnNumber) {
            this.isbnNumber = isbnNumber;
            return this;
        }
        
        public BooksBuilder book(Books books){
            id = books.getId();
            bookName = books.getBookName();
            isbnNumber = books.getIsbnNumber();
            return this;
        }
        
        public Books build(){
            return new Books(this);
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
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alex.libraryweb.domain.Books[ id=" + id + " ]";
    }
    
}
