/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

/**
 *
 * @author Birche
 */
@javax.persistence.Entity
public class AlternativeText extends Entity {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + (this.text != null ? this.text.hashCode() : 0);
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
        final AlternativeText other = (AlternativeText) obj;
        if ((this.text == null) ? (other.text != null) : !this.text.equals(other.text)) {
            return false;
        }
        return true;
    }
    
}
