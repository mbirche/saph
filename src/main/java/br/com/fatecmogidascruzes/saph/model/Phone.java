package br.com.fatecmogidascruzes.saph.model;

import javax.persistence.Enumerated;

/**
 * All fonts were produced for author's graduation project
 *
 * @date 19/02/2014
 * @author Birche
 */
@javax.persistence.Entity
public class Phone extends Entity {

    private String code;
    private String number;
    @Enumerated
    private PhoneType phoneType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }
}
