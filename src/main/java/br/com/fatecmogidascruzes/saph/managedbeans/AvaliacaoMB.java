package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.interfaces.IQuestionFacade;
import br.com.fatecmogidascruzes.saph.interfaces.ITestApplicationFacade;
import br.com.fatecmogidascruzes.saph.interfaces.ITestFacade;
import br.com.fatecmogidascruzes.saph.model.Question;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.Test;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.TransferEvent;
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
    private List<Test> allTests;
    
    private TestApplication testApplication;
    private List<TestApplication> allApplications;
    private List<TestApplication> loggedApplications;
    
    private DualListModel<Question> dualListModel;
    private List<Question> allQuestions;
    private List<Question> questionsAux;
    
    private IQuestionFacade qFacade;
    private ITestFacade tFacade;
    private ITestApplicationFacade tAppFacade;

    public AvaliacaoMB() {
        
        qFacade = (IQuestionFacade)FacadeFactory.getInstance().getFacade(Question.class);
        tFacade = (ITestFacade)FacadeFactory.getInstance().getFacade(Test.class);
        tAppFacade = (ITestApplicationFacade)FacadeFactory.getInstance().getFacade(TestApplication.class);
        
        test = new Test();
       
        testApplication = new TestApplication();
        
        fillApplicationsList();
        fillTestsList();
        fillQuestionsList();
        
       
        dualListModel = new DualListModel<Question>(questionsAux, test.getQuestions());
    }

    public void saveApplication(){
        tAppFacade.save(testApplication);
        testApplication = new TestApplication();
        fillApplicationsList();
    }
    public void saveTest(){
        tFacade.save(test);
        test = new Test();
        fillQuestionsList();
        fillTestsList();
    }
    public void onTransfer(TransferEvent event) {
        if (event.isAdd()) {
            for (Object o : event.getItems()) {
                Question q = (Question) o;
                test.getQuestions().add(q);
            }
        } else {
            for (Object o : event.getItems()) {
                Question q = (Question) o;
                test.getQuestions().remove(q);
            }
        }
    }
    public void refreshTestManagementWindow(){
        fillQuestionsList();
    }
    private void fillLoggedApplicationsList(){
        loggedApplications = new ArrayList<TestApplication>(allApplications);
        List<TestApplication> toBeRemoved = new ArrayList<TestApplication>();
        
        for(TestApplication ta : loggedApplications){
            for(StudentClass st : ta.getClassAssignment().getStudentClasses()){
                if(!st.getStudents().contains(LoginMB.getLoggedUser())){
                    toBeRemoved.add(ta);
                }
            }
        }
        loggedApplications.removeAll(toBeRemoved);
    }
    public void fillApplicationsList(){
        allApplications = (List<TestApplication>) (List) tAppFacade.getAll(TestApplication.class);
        fillLoggedApplicationsList();
    }
    private void fillTestsList(){
         allTests = (List<Test>) (List) tFacade.getAll(Test.class);
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

    public List<Test> getAllTests() {
        return allTests;
    }

    public void setAllTests(List<Test> allTests) {
        this.allTests = allTests;
    }

    public TestApplication getTestApplication() {
        return testApplication;
    }

    public void setTestApplication(TestApplication testApplication) {
        this.testApplication = testApplication;
    }

    public List<TestApplication> getAllApplications() {
        return allApplications;
    }

    public void setAllApplications(List<TestApplication> allApplications) {
        this.allApplications = allApplications;
    }    

    public List<TestApplication> getLoggedApplications() {
        return loggedApplications;
    }

    public void setLoggedApplications(List<TestApplication> loggedApplications) {
        this.loggedApplications = loggedApplications;
    }
    
}
