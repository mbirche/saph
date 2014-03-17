package br.com.fatecmogidascruzes.saph.model;

/**
 * All fonts were produced for author's graduation project
 *
 * @date 13/02/2014
 * @author Birche
 */
public enum PhoneType {

    CELLPHONE(0), FIXED(1);
    private Integer code;

    private PhoneType(Integer code) {
        this.code = code;
    }

    public Integer geCode() {
        return code;
    }
}
