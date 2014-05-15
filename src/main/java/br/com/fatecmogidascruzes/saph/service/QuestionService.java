/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.service;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.dao.QuestionDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IQuestionService;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Question;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class QuestionService extends AbstractService implements IQuestionService{

     private static QuestionService service;
    private QuestionDAO dao;
    public static QuestionService getInstance(){
        if(service == null){
            service = new QuestionService();
            return service;
        }else{
            return service;
        }
    }   
    public QuestionService(){
        dao = (QuestionDAO) DAOFactory.getInstance().getDAO(Question.class);
    }
    @Override
    public List<Question> getQuestionsByAbility(Ability ability) {
        return dao.getQuestionsByAbility(ability);
    }
    
}
