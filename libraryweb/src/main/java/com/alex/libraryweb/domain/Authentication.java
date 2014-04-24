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
public class Authentication implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    public Authentication() {
    }

    public Authentication(AuthenticationBuilder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    } 

    public Long getId() {
        return id;
    }
    
    public static class AuthenticationBuilder{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String username;
        private String password;

        public AuthenticationBuilder(Long id) {
            this.id = id;
        }

        public AuthenticationBuilder username(String username) {
            this.username = username;
            return this;
        }

        public AuthenticationBuilder password(String password) {
            this.password = password;
            return this;
        }
        
        public AuthenticationBuilder authentication(Authentication auth){
            id = auth.getId();
            username = auth.getUsername();
            password = auth.getUsername();
            return this;
        }
        
        public Authentication build(){
            return new Authentication(this);
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
        if (!(object instanceof Authentication)) {
            return false;
        }
        Authentication other = (Authentication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alex.libraryweb.domain.Authentication[ id=" + id + " ]";
    }
    
}
