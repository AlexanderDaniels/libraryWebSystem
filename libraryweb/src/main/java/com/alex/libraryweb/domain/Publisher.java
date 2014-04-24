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
public class Publisher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String publisherName;
    
    @Embedded
    private Contact contact;

    public Publisher() {
    }

    public Publisher(PublisherBuilder builder) {
        this.id = builder.id;
        this.publisherName = builder.publisherName;
        this.contact = builder.contact;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public Contact getContact() {
        return contact;
    }   
    
    public Long getId() {
        return id;
    }

    public static class PublisherBuilder{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String publisherName;

        @Embedded
        private Contact contact;

        public PublisherBuilder(Long id) {
            this.id = id;
        }

        public PublisherBuilder publisherName(String publisherName) {
            this.publisherName = publisherName;
            return this;
        }

        public PublisherBuilder contact(Contact contact) {
            this.contact = contact;
            return this;
        }   
        
        public PublisherBuilder publisher(Publisher publish){
            id = publish.getId();
            publisherName = publish.getPublisherName();
            contact = publish.getContact();
            return this;        
        }
        
        public Publisher build(){
            return new Publisher(this);
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
        if (!(object instanceof Publisher)) {
            return false;
        }
        Publisher other = (Publisher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alex.libraryweb.domain.Publisher[ id=" + id + " ]";
    }
    
}
