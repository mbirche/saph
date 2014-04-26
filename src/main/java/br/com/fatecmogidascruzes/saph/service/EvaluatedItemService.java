/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.service;

import br.com.fatecmogidascruzes.saph.dao.EvaluatedItemDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IEvaluatedItemFacade;
import br.com.fatecmogidascruzes.saph.interfaces.IEvaluatedItemService;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.EvaluatedItem;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class EvaluatedItemService extends AbstractService implements IEvaluatedItemFacade, IEvaluatedItemService{

    private static EvaluatedItemService service;
    private EvaluatedItemDAO dao;
    public static EvaluatedItemService getInstance(){
        if(service == null){
            service = new EvaluatedItemService();
            return service;
        }else{
            return service;
        }
    }   
    public EvaluatedItemService(){
        dao = new EvaluatedItemDAO();
    }
    @Override
    public List<EvaluatedItem> getEvaluatedItemsByAbility(Ability ability) {
        return dao.getEvaluatedItemsByAbility(ability);
    }
    
}
