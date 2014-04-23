/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.libraryweb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Alex
 */
@Embeddable
public class Demographics implements Serializable {
    private String gender;
    private String race;

    public Demographics() {
    }

    public Demographics(DemographicsBuilder builder) {
        this.gender = builder.gender;
        this.race = builder.race;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }
    
    public static class DemographicsBuilder{
        private String gender;
        private String race;

        public DemographicsBuilder() {
        }        

        public DemographicsBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public DemographicsBuilder race(String race) {
            this.race = race;
            return this;
        }
        
        public DemographicsBuilder demographics(Demographics demographics){
            
            gender = demographics.getGender();
            race = demographics.getRace();
            
            return this;
        }
        
        public Demographics build(){
            return new Demographics(this);
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
        final Demographics other = (Demographics) obj;
        return true;
    }

    
}
