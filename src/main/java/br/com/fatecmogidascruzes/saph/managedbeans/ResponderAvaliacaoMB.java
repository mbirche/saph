package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.interfaces.ITestApplicationFacade;
import br.com.fatecmogidascruzes.saph.interfaces.ITestResultFacade;
import br.com.fatecmogidascruzes.saph.model.Alternative;
import br.com.fatecmogidascruzes.saph.model.Answer;
import br.com.fatecmogidascruzes.saph.model.Question;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import br.com.fatecmogidascruzes.saph.model.TestResult;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author marcelo
 */
@ManagedBean(name = "responderAvaliacaoMB")
@SessionScoped
public class ResponderAvaliacaoMB {
    
    private TestResult testResult;
    
    private Answer answer;
    
    private List<Question> questionsToAnswer;
    
    private List<TestApplication> allApplications;
    private List<TestApplication> loggedApplications;
    
    private List<TestResult> allTestResults;
    
    private ITestApplicationFacade tAppFacade;
    private ITestResultFacade testResultFacade;

    
    public ResponderAvaliacaoMB() {
        testResult = new TestResult();
        testResult.setStudent(LoginMB.getLoggedUser());
        
        tAppFacade = (ITestApplicationFacade)FacadeFactory.getInstance().getFacade(TestApplication.class);
        testResultFacade = (ITestResultFacade)FacadeFactory.getInstance().getFacade(TestResult.class);
        
        fillApplicationsList();
        
        
    }

    private void fillTestResultList(){
        allTestResults = (List<TestResult>) (List) testResultFacade.getTestResultsByStudent(LoginMB.getLoggedUser());
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
        
        for(TestResult tr : allTestResults){
            for(TestApplication ta : loggedApplications){
                if(tr.getTestApplication().equals(ta)){
                    toBeRemoved.add(ta);
                }
            }
        }
        loggedApplications.removeAll(toBeRemoved);
    }
    public void fillApplicationsList(){
        allApplications = (List<TestApplication>) (List) tAppFacade.getAll(TestApplication.class);
        fillTestResultList();
        fillLoggedApplicationsList();
    }
    
    public void finishTest(){
        testResult.setAnswered(true);
        testResult.setStudent(LoginMB.getLoggedUser());
        testResultFacade.save(testResult);
        testResult = new TestResult();
        fillApplicationsList();
    }
    public void chooseAlternative(Question question, Alternative alternative){
        answer = new Answer();
        
        answer.setQuestion(question);
        answer.setAlternative(alternative);
        
        testResult.addAnswer(answer);
        
        questionsToAnswer.remove(question);
    }
    public void startResponding(TestApplication ta){
        testResult.setTestApplication(ta);
        
        questionsToAnswer = new ArrayList<Question>(ta.getTest().getQuestions());
        
    }
    public TestResult getTestResult() {
        return testResult;
    }

    public void setTestResult(TestResult testResult) {
        this.testResult = testResult;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
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

    public List<Question> getQuestionsToAnswer() {
        return questionsToAnswer;
    }

    public void setQuestionsToAnswer(List<Question> questionsToAnswer) {
        this.questionsToAnswer = questionsToAnswer;
    }
    
}
