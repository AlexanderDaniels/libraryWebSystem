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
public class ReturnBooks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookName;
    private String isbnNumber;

    public ReturnBooks() {
    }

    public ReturnBooks(ReturnBooksBuilder builder) {
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
    
    public static class ReturnBooksBuilder{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String bookName;
        private String isbnNumber;

        public ReturnBooksBuilder(Long id) {
            this.id = id;
        }        

        public ReturnBooksBuilder bookName(String bookName) {
            this.bookName = bookName;
            return this;
        }

        public ReturnBooksBuilder isbnNumber(String isbnNumber) {
            this.isbnNumber = isbnNumber;
            return this;
        }
        
        public ReturnBooksBuilder returnBook(ReturnBooks returnBook){
            id = returnBook.getId();
            bookName = returnBook.getBookName();
            isbnNumber = returnBook.getIsbnNumber();
            
            return this;
        }
        
        public ReturnBooks build(){
            return new ReturnBooks(this);
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
        if (!(object instanceof ReturnBooks)) {
            return false;
        }
        ReturnBooks other = (ReturnBooks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alex.libraryweb.domain.ReturnBooks[ id=" + id + " ]";
    }
    
}
