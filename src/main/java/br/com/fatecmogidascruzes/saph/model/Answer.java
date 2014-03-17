/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import javax.persistence.OneToOne;

/**
 *
 * @author Birche
 */
@javax.persistence.Entity
public class Answer extends Entity {

    @OneToOne
    private Question question;
    
    @OneToOne
    private Alternative alternative;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }
}
