/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToMany;
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
    @ManyToMany
    private List<Alternative> alternatives;
    
    @Cascade(CascadeType.ALL)
    @OneToOne
    private QuestionText questionText;

    public Integer numberOfHits(Ability ability){
        Integer nHits = 0;
        
        for(Alternative alt : alternatives){
            for(EvaluatedItem ev : alt.getEvaluatedItems()){
                if(ev.getAbility().equals(ability) && ev.getPerformance().equals(Performance.SATISFATORY)){
                    nHits++;
                }
            }
        }
        return nHits;
    }
    public Boolean hasAbility(Ability ability){
        for(Alternative alt : alternatives){
            if(alt.hasAbility(ability)){
                return true;
            }
        }
        return false;
    }
    public Boolean addAlternative(Alternative alt){
        return alternatives.add(alt);
    }
    public Question(){
        alternatives = new ArrayList<Alternative>();
        questionText = new QuestionText();
    }
    public List<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    public QuestionText getQuestionText() {
        return questionText;
    }

    public void setQuestionText(QuestionText questionText) {
        this.questionText = questionText;
    }
}
