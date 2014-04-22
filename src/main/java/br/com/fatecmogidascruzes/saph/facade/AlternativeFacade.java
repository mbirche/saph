/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.dao.AbilityDAO;
import br.com.fatecmogidascruzes.saph.dao.AlternativeDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IAlternativeFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Alternative;
import br.com.fatecmogidascruzes.saph.model.EvaluatedItem;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import br.com.fatecmogidascruzes.saph.model.Performance;
import java.util.List;

/**
 *
 * @author Birche
 */
public class AlternativeFacade  extends AbstractFacade implements IAlternativeFacade{

    private static AlternativeFacade facade;
    private AlternativeDAO dao;
    public static AlternativeFacade getInstance(){
        if(facade == null){
            facade = new AlternativeFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private AlternativeFacade(){
        dao = new AlternativeDAO();
    }
    
    @Override
    public List<EvaluatedItem> getEvaluatedItemsByAbility(Alternative alternative, Ability ability) {
        return dao.getEvaluatedItemsByAbility(alternative, ability);
    }

    @Override
    public List<EvaluatedItem> getEvaluatedItemsByPerformance(Alternative alternative, Performance performance) {
        return dao.getEvaluatedItemsByPerformance(alternative, performance);
    }

    @Override
    public List<Alternative> getAlternativesByAbility(Ability ability) {
        return dao.getAlternativesByAbility(ability);
    }

    @Override
    public List<Alternative> getAlternativesByKnowledgeArea(KnowledgeArea kArea) {
        return dao.getAlternativesByKnowledgeArea(kArea);
    }
    
}
