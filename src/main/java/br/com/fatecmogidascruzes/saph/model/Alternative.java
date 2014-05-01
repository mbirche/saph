/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Birche
 */
@javax.persistence.Entity
public class Alternative extends Entity {

    @Cascade(CascadeType.ALL)
    @ManyToMany
    private Set<EvaluatedItem> evaluatedItems;
    
    @Cascade(CascadeType.ALL)
    @OneToOne
    private AlternativeText alternativeText;

    public Boolean addEvaluatedItem(EvaluatedItem evItem){
        return evaluatedItems.add(evItem);
    }
    public Alternative(){
        evaluatedItems = new HashSet<EvaluatedItem>();
    }
    public List<Long> getEvaluatedItemsIds(){
        List<Long> ids = new ArrayList<Long>();
        for(EvaluatedItem ev : evaluatedItems){
            ids.add(ev.getId());
        }
        return ids;
    }
    public Set<EvaluatedItem> getEvaluatedItems() {
        return evaluatedItems;
    }

    public void setEvaluatedItems(Set<EvaluatedItem> evaluatedItems) {
        this.evaluatedItems = evaluatedItems;
    }

    public AlternativeText getAlternativeText() {
        return alternativeText;
    }

    public void setAlternativeText(AlternativeText alternativeText) {
        this.alternativeText = alternativeText;
    }
}
