/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.controller;

import br.com.fatecmogidascruzes.saph.dao.AbilityDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IAbilityFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import java.util.List;

/**
 *
 * @author Birche
 */
public class AbilityFacade extends AbstractFacade implements IAbilityFacade{

    private static AbilityFacade facade;
    private AbilityDAO dao;
    public static AbilityFacade getInstance(){
        if(facade == null){
            facade = new AbilityFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private AbilityFacade(){
        dao = new AbilityDAO();
    }

    @Override
    public List<Ability> getAbilityByKnowledgeArea(KnowledgeArea kArea) {
        return dao.getAbilityByKnowledgeArea(kArea);
    }

}
