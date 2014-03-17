package br.com.fatecmogidascruzes.saph.interfaces;

import br.com.fatecmogidascruzes.saph.config.HSession;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Question;
import java.util.List;
import org.hibernate.Query;

/**
 * All fonts were produced for author's graduation project
 * @date 05/03/2014
 * @author Birche
 */
public interface IQuestionFacade extends IAbstractFacade{

    
    public List<Question> getQuestionsByAbility(Ability ability);
    
}
