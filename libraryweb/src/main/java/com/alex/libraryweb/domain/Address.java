/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.libraryweb.domain;

/**
 *
 * @author Alex
 */
public final class Address {
    private String email;
    private String telephoneNum;
    private String cellphoneNum;

    public Address() {
    }

    
    public Address(AddressBuilder builder) {
        email = builder.email;
        telephoneNum = builder.telephoneNum;
        cellphoneNum = builder.cellphoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public String getCellphoneNum() {
        return cellphoneNum;
    }
    
    public static class AddressBuilder{
        private String email;
        private String telephoneNum;
        private String cellphoneNum;

        public AddressBuilder() {
        }       

        public AddressBuilder email(String value) {
            email = value;
            return this;
        }

        public AddressBuilder telephoneNum(String value) {
            telephoneNum = value;
            return this;
        }

        public AddressBuilder cellphoneNum(String value) {
            cellphoneNum = value;
            return this;
        }
        
        public AddressBuilder address(Address address){
            email = address.getEmail();
            telephoneNum = address.getTelephoneNum();
            cellphoneNum = address.getCellphoneNum();
            
            return this;
        }
        
        public Address build(){
            return new Address(this);
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
        final Address other = (Address) obj;
        return true;
    }

    
}
