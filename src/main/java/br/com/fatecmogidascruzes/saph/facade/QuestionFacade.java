/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.controller.ServiceFactory;
import br.com.fatecmogidascruzes.saph.interfaces.IQuestionFacade;
import br.com.fatecmogidascruzes.saph.interfaces.IQuestionService;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Question;
import java.util.List;

/**
 *
 * @author Birche
 */
public class QuestionFacade extends AbstractFacade implements IQuestionFacade {

    private static QuestionFacade facade;
    private IQuestionService service;
    public static QuestionFacade getInstance(){
        if(facade == null){
            facade = new QuestionFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private QuestionFacade(){
        service = (IQuestionService)ServiceFactory.getInstance().getService(Question.class);
    }

    @Override
    public List<Question> getQuestionsByAbility(Ability ability) {
        return service.getQuestionsByAbility(ability);
    }
}
