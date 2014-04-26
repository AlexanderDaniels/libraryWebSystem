/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alex.libraryweb.repository;

import com.alex.libraryweb.domain.PayBill;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Alex
 */
public interface PayBillRepository extends JpaRepository<PayBill, Long>{
    
}
