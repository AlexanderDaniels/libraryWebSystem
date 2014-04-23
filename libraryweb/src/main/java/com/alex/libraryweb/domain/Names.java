/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * @author Alex
 */
@Embeddable
public class Names implements Serializable{
    
    private String firstName;
    private String lastName;

    public Names() {
    }

    public Names(NamesBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public static class NamesBuilder{
        
        private String firstName;
        private String lastName;

        public NamesBuilder() {
        }
        
        public NamesBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        
        public NamesBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        
        public NamesBuilder name(Names name){
            firstName = name.getFirstName();
            lastName = name.getLastName();
            
            return this;
        }
        
        public Names build(){
            return new Names(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Names other = (Names) obj;
        return true;
    }
    
    
    
}
