/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

/**
 *
 * @author Birche
 */
public enum Performance {

    SATISFATORY(0), INSATISFATORY(1);
    private Integer code;

    private Performance(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
