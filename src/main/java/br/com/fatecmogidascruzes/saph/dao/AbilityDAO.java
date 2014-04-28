/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.config.HSession;
import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.interfaces.IAbilityFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Alternative;
import br.com.fatecmogidascruzes.saph.model.Entity;
import br.com.fatecmogidascruzes.saph.model.EvaluatedItem;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import br.com.fatecmogidascruzes.saph.model.Question;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author marcelo
 */
public class AbilityDAO extends AbstractDAO implements IAbilityFacade{

    private static AbilityDAO dao;

    public static AbilityDAO getInstance() {
        if (dao == null) {
            dao = new AbilityDAO();
            return dao;
        } else {
            return dao;
        }
    }

    @Override
    public List<Ability> getAbilityByKnowledgeArea(KnowledgeArea kArea) {

        session = HSession.getSession();
        String hql = "from Ability ability WHERE " + kArea.getId() + " IN (SELECT ka.id FROM ability.knowledgeAreas as ka)";
        Query q = session.createQuery(hql);
        List entities = q.list();
        session.close();
        return entities;
    }
    @Override
    public void delete(Entity entity){
        
        EvaluatedItemDAO evDAO = (EvaluatedItemDAO)DAOFactory.getInstance().getDAO(EvaluatedItem.class);
        QuestionDAO qDAO = (QuestionDAO)DAOFactory.getInstance().getDAO(Question.class);
        AlternativeDAO altDAO = (AlternativeDAO)DAOFactory.getInstance().getDAO(Alternative.class);
        
        Ability deletingAbility = (Ability)entity;
        deletingAbility.getKnowledgeAreas().clear();
        update(deletingAbility);
        List<Question> qList;
        List<EvaluatedItem> evList = evDAO.getEvaluatedItemsByAbility(deletingAbility);

        for (EvaluatedItem eva : evList) {
            Ability abilityAux = eva.getAbility();
            qList = qDAO.getQuestionsByAbility(abilityAux);
            for (Question q : qList) {
                for (Alternative alt : q.getAlternatives()) {
                    List<EvaluatedItem> evListAux = new ArrayList<EvaluatedItem>(alt.getEvaluatedItems());
                    for (EvaluatedItem ev : evListAux) {
                        if (ev.getAbility().getId().equals(abilityAux.getId())) {
                            alt.getEvaluatedItems().remove(ev);
                        }
                    }
                    altDAO.update(alt);
                }
                qDAO.update(q);
            }
            evDAO.delete(eva);
        }

        super.delete(deletingAbility);
    }
}
