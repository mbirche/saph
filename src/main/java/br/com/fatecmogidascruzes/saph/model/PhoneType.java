package br.com.fatecmogidascruzes.saph.model;

/**
 * All fonts were produced for author's graduation project
 *
 * @date 13/02/2014
 * @author Birche
 */
public enum PhoneType {

    CELLPHONE(0, "Celular"), FIXED(1, "Fixo");
    private Integer code;
    private String description;

    private PhoneType(Integer code, String description) {
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
