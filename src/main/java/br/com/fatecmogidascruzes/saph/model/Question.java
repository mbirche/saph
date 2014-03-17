/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Birche
 */
@javax.persistence.Entity
public class Question extends Entity {

    @Cascade(CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Alternative> alternatives;
    
    @Cascade(CascadeType.ALL)
    @OneToOne
    private QuestionText questionText;

    public Boolean addAlternative(Alternative alt){
        return alternatives.add(alt);
    }
    public Question(){
        alternatives = new HashSet<Alternative>();
    }
    public Set<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(Set<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    public QuestionText getQuestionText() {
        return questionText;
    }

    public void setQuestionText(QuestionText questionText) {
        this.questionText = questionText;
    }
}
