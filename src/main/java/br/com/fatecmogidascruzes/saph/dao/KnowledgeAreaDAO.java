/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Entity;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class KnowledgeAreaDAO extends AbstractDAO{
    
    private static KnowledgeAreaDAO dao;
    public static KnowledgeAreaDAO getInstance(){
        if(dao == null){
            dao = new KnowledgeAreaDAO();
            return dao;
        }else{
            return dao;
        }
    }   
    
    @Override
    public void delete(Entity entity){
        KnowledgeArea deletingKArea = (KnowledgeArea) entity;
        
        AbilityDAO abDAO = (AbilityDAO)DAOFactory.getInstance().getDAO(Ability.class);
        
        List<Ability> abilities = abDAO.getAbilityByKnowledgeArea(deletingKArea);
        
        for(Ability ab : abilities){
            if(ab.getKnowledgeAreas().contains(deletingKArea)){
                ab.getKnowledgeAreas().remove(deletingKArea);
                abDAO.update(ab);
            }
        }
        
        super.delete(deletingKArea);
    }
}
