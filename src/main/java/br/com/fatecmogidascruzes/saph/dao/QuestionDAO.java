package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.config.HSession;
import br.com.fatecmogidascruzes.saph.interfaces.IQuestionFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Question;
import java.util.List;
import org.hibernate.Query;

/**
 * All fonts were produced for author's graduation project
 *
 * @date 05/03/2014
 * @author Birche
 */
public class QuestionDAO extends AbstractDAO implements IQuestionFacade{

    private static QuestionDAO dao;

    public static QuestionDAO getInstance() {
        if (dao == null) {
            dao = new QuestionDAO();
            return dao;
        } else {
            return dao;
        }
    }

    @Override
    public List<Question> getQuestionsByAbility(Ability ability) {
        
        session = HSession.getSession();
        String hql = "from Question que WHERE " + ability.getId() + " IN (SELECT ev.ability.id from que.alternatives as alts join alts.evaluatedItems as ev)";
        Query q = session.createQuery(hql);
        
        List entities = q.list();
        session.close();
        return entities;
    }
}
