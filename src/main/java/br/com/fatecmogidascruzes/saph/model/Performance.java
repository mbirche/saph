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

    SATISFATORY(0, "Satisfatório"), INSATISFATORY(1, "Insatisfatório");
    private Integer code;
    private String description;

    private Performance(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }
    public String getDescription(){
        return description;
    }
}
