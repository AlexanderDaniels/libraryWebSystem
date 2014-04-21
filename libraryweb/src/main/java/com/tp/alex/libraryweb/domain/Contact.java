/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tp.alex.libraryweb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Alex
 */
@Embeddable
public class Contact implements Serializable{
    
    private String landline;
    private String address;
    private String cell;

    public Contact(ContactBuilder builder) {
        this.landline = builder.landline;
        this.address = builder.address;
        this.cell = builder.cell;
    }

    public String getLandline() {
        return landline;
    }

    public String getAddress() {
        return address;
    }

    public String getCell() {
        return cell;
    }
    
    public static class ContactBuilder{
        private String landline;
        private String address;
        private String cell;

        public ContactBuilder() {
        }
        
        public ContactBuilder landline(String landline){
            this.landline = landline;
            return this;
        }
        
        public ContactBuilder address(String address){
            this.address = address;
            return this;
        }
        
        public ContactBuilder cell(String cell){
            this.cell = cell;
            return this;
        }
        
        public ContactBuilder contact(Contact con){
            landline = con.getLandline();
            address = con.getAddress();
            cell = con.getCell();
            return this;            
        }
        
        public Contact build(){
            return new Contact(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Contact other = (Contact) obj;
        return true;
    }    
}
