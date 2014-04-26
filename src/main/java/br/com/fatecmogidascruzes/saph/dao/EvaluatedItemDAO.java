/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.config.HSession;
import br.com.fatecmogidascruzes.saph.interfaces.IEvaluatedItemFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.EvaluatedItem;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author marcelo
 */
public class EvaluatedItemDAO extends AbstractDAO implements IEvaluatedItemFacade{
    
    private static EvaluatedItemDAO dao;
    public static EvaluatedItemDAO getInstance(){
        if(dao == null){
            dao = new EvaluatedItemDAO();
            return dao;
        }else{
            return dao;
        }
    }

    @Override
    public List<EvaluatedItem> getEvaluatedItemsByAbility(Ability ability) {
        session = HSession.getSession();
        String hql = "from EvaluatedItem ev WHERE " + ability.getId() + " = ev.ability.id";
        Query q = session.createQuery(hql);
        
        List<EvaluatedItem> entities = (List<EvaluatedItem>)q.list();
        session.close();
        return entities;
    }

}
