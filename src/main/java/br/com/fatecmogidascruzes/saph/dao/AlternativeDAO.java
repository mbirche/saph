/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.config.HSession;
import br.com.fatecmogidascruzes.saph.interfaces.IAlternativeFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Alternative;
import br.com.fatecmogidascruzes.saph.model.EvaluatedItem;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import br.com.fatecmogidascruzes.saph.model.Performance;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.transform.ResultTransformer;

/**
 *
 * @author marcelo
 */
public class AlternativeDAO extends AbstractDAO implements IAlternativeFacade {

    private static AlternativeDAO dao;

    public static AlternativeDAO getInstance() {
        if (dao == null) {
            dao = new AlternativeDAO();
            return dao;
        } else {
            return dao;
        }
    }

    @Override
    public List<EvaluatedItem> getEvaluatedItemsByAbility(Alternative alternative, Ability ability) {

        session = HSession.getSession();
        String hql = "from EvaluatedItem ev WHERE ev IN (:evList) AND ev.ability.id = :abId";
        Query q = session.createQuery(hql);
        q.setParameterList("evList", alternative.getEvaluatedItems());
        q.setParameter("abId", ability.getId());

        List entities = q.list();
        session.close();
        return entities;

    }

    @Override
    public List<EvaluatedItem> getEvaluatedItemsByPerformance(Alternative alternative, Performance performance) {
        
        session = HSession.getSession();
        String hql = "from EvaluatedItem ev WHERE ev IN (:evList) AND ev.performance = :performance";
        Query q = session.createQuery(hql);
        q.setParameterList("evList", alternative.getEvaluatedItems());
        q.setParameter("performance", performance);

        List entities = q.list();
        session.close();
        return entities;
    }

    @Override
    public List<Alternative> getAlternativesByAbility(Ability ability) {
        
        session = HSession.getSession();
        String hql = "from Alternative alt WHERE " + ability.getId() + " IN (SELECT ev.ability.id FROM alt.evaluatedItems as ev)";
        Query q = session.createQuery(hql);
        
        List entities = q.list();
        session.close();
        return entities;
    }

    @Override
    public List<Alternative> getAlternativesByKnowledgeArea(KnowledgeArea kArea) {
        
        session = HSession.getSession();
        String hql = " SELECT alt FROM Alternative alt inner join alt.evaluatedItems ev inner join ev.ability.knowledgeAreas ka WHERE :kAreaId = ka.id";
        Query q = session.createQuery(hql);
        q.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        q.setParameter("kAreaId", kArea.getId());
        
        List entities = q.list();
        session.close();
        return entities;
        
    }

}
