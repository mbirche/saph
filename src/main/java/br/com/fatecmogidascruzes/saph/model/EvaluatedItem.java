/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Birche
 */
@javax.persistence.Entity
public class EvaluatedItem extends Entity {

    @Cascade(CascadeType.ALL)
    @OneToOne
    private Ability ability;
    
    
    @Enumerated
    private Performance performance;

    public EvaluatedItem() {
    }

    public EvaluatedItem(Ability ability, Performance performance){
        this.ability = ability;
        this.performance = performance;
    }
    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }
}
