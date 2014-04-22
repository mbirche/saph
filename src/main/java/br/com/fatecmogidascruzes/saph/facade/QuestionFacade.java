/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.dao.QuestionDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IQuestionFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Question;
import java.util.List;

/**
 *
 * @author Birche
 */
public class QuestionFacade extends AbstractFacade implements IQuestionFacade {

    private static QuestionFacade facade;
    private QuestionDAO dao;
    public static QuestionFacade getInstance(){
        if(facade == null){
            facade = new QuestionFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private QuestionFacade(){
        dao = new QuestionDAO();
    }

    @Override
    public List<Question> getQuestionsByAbility(Ability ability) {
        return dao.getQuestionsByAbility(ability);
    }
}
