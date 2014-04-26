/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.interfaces.IEvaluatedItemFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.EvaluatedItem;
import br.com.fatecmogidascruzes.saph.service.EvaluatedItemService;
import java.util.List;

/**
 *
 * @author Birche
 */
public class EvaluatedItemFacade extends AbstractFacade implements IEvaluatedItemFacade{
    
    private static EvaluatedItemFacade facade;
    private EvaluatedItemService service;
    public static EvaluatedItemFacade getInstance(){
        if(facade == null){
            facade = new EvaluatedItemFacade();
            return facade;
        }else{
            return facade;
        }
    }   

    public EvaluatedItemFacade() {
        service = new EvaluatedItemService();
    }
    

    @Override
    public List<EvaluatedItem> getEvaluatedItemsByAbility(Ability ability) {
        return service.getEvaluatedItemsByAbility(ability);
    }
}
