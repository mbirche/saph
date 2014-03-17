/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Birche
 */
@javax.persistence.Entity
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User {

    private String rn;

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }
}
