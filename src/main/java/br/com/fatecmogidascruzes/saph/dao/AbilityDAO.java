/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.config.HSession;
import br.com.fatecmogidascruzes.saph.interfaces.IAbilityFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author marcelo
 */
public class AbilityDAO extends AbstractDAO implements IAbilityFacade {

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

}
