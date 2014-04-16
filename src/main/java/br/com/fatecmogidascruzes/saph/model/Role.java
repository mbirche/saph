/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

/**
 *
 * @author Birche
 */

public enum Role {

    ADMINISTRATOR(0), COORDINATOR(1), TEACHER(2), STUDENT(3);
    private Integer code;

    private Role(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
    
}
