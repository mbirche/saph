/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.controller;

import br.com.fatecmogidascruzes.saph.interfaces.IAbstractFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Alternative;
import br.com.fatecmogidascruzes.saph.model.EvaluatedItem;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import br.com.fatecmogidascruzes.saph.model.Question;
import br.com.fatecmogidascruzes.saph.model.Test;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marcelo
 */
public class FacadeFactory {
    
    private Map<Class, IAbstractFacade> map;
    private static FacadeFactory factory;
    
    public IAbstractFacade getFacade(Class cl){
        return map.get(cl);
    }
    public static FacadeFactory getInstance(){
        if(factory == null){
            return new FacadeFactory();
        }else{
            return factory;
        }
    }
    private FacadeFactory(){
        map = new HashMap<Class, IAbstractFacade>();
        
        map.put(KnowledgeArea.class, KnowledgeAreaFacade.getInstance());
        map.put(Ability.class, AbilityFacade.getInstance());
        map.put(EvaluatedItem.class, EvaluatedItemFacade.getInstance());
        map.put(Alternative.class, AlternativeFacade.getInstance());
        map.put(Question.class, QuestionFacade.getInstance());
        map.put(Test.class, TestFacade.getInstance());
    }
    
}
