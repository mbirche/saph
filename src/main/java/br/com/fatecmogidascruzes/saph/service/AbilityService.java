/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.service;

import br.com.fatecmogidascruzes.saph.dao.AbilityDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IAbilityFacade;
import br.com.fatecmogidascruzes.saph.interfaces.IAbilityService;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class AbilityService extends AbstractService implements IAbilityService, IAbilityFacade{

    private static AbilityService service;
    private AbilityDAO dao;
    public static AbilityService getInstance(){
        if(service == null){
            service = new AbilityService();
            return service;
        }else{
            return service;
        }
    }   
    public AbilityService(){
        dao = new AbilityDAO();
    }

    @Override
    public List<Ability> getAbilityByKnowledgeArea(KnowledgeArea kArea) {
        return dao.getAbilityByKnowledgeArea(kArea);
    }
}
