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

    Coordenador(0), Professor(1), Aluno(2);
    private Integer code;

    private Role(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static Role getRole(Integer code) {
        switch (code) {
            case 0:
                return Coordenador;

            case 1:
                return Professor;

            case 2:
                return Aluno;
            default:
                return null;
        }
    }

}
