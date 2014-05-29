package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.interfaces.IQuestionFacade;
import br.com.fatecmogidascruzes.saph.interfaces.ITestFacade;
import br.com.fatecmogidascruzes.saph.model.Question;
import br.com.fatecmogidascruzes.saph.model.Test;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DualListModel;

/**
 * All fonts were produced for author's graduation project
 * @date 17/04/2014
 * @author Birche
 */
@ManagedBean(name="avaliacaoMB")
@SessionScoped
public class AvaliacaoMB {

    private Test test;
    private DualListModel<Question> dualListModel;
    private List<Question> allQuestions;
    private List<Question> questionsAux;
    
    private IQuestionFacade qFacade;
    private ITestFacade tFacade;

    public AvaliacaoMB() {
        
        qFacade = (IQuestionFacade)FacadeFactory.getInstance().getFacade(Question.class);
        tFacade = (ITestFacade)FacadeFactory.getInstance().getFacade(Test.class);
        test = new Test();
        
        fillQuestionsList();
        
       
        dualListModel = new DualListModel<Question>(questionsAux, test.getQuestions());
    }

    public void refreshTestManagementWindow(){
        fillQuestionsList();
    }
    private void fillQuestionsList(){
        allQuestions = (List<Question>)(List)qFacade.getAll(Question.class);
        questionsAux = new ArrayList<Question>(allQuestions);
        
        for(Question q : test.getQuestions()){
            if(questionsAux.contains(q)){
                questionsAux.remove(q);
            }
        }
        dualListModel = new DualListModel<Question>(questionsAux, test.getQuestions());
    }
    public DualListModel getDualListModel() {
        return dualListModel;
    }

    public void setDualListModel(DualListModel dualListModel) {
        this.dualListModel = dualListModel;
    }    

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
    
}
