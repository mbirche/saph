/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.interfaces.IAbilityFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import br.com.fatecmogidascruzes.saph.service.AbilityService;
import java.util.List;

/**
 *
 * @author Birche
 */
public class AbilityFacade extends AbstractFacade implements IAbilityFacade{

    private static AbilityFacade facade;
    private AbilityService service;
    public static AbilityFacade getInstance(){
        if(facade == null){
            facade = new AbilityFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private AbilityFacade(){
        service = new AbilityService();
    }

    @Override
    public List<Ability> getAbilityByKnowledgeArea(KnowledgeArea kArea) {
        return service.getAbilityByKnowledgeArea(kArea);
    }

}
