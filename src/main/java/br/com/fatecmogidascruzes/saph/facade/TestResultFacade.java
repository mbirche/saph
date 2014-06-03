package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.interfaces.ITestResultFacade;
import br.com.fatecmogidascruzes.saph.model.TestApplication;

import br.com.fatecmogidascruzes.saph.model.TestResult;
import br.com.fatecmogidascruzes.saph.model.User;
import br.com.fatecmogidascruzes.saph.service.TestResultService;
import java.util.List;

/**
 * All fonts were produced for author's graduation project
 * @date 24/03/2014
 * @author Birche
 */
public class TestResultFacade extends AbstractFacade implements ITestResultFacade{

    private static TestResultFacade facade;
    private TestResultService service;
    public static TestResultFacade getInstance(){
        if(facade == null){
            facade = new TestResultFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private TestResultFacade(){
        service = new TestResultService();
    }

    @Override
    public List<TestResult> getTestResultsByStudent(User student) {
        return service.getTestResultsByStudent(student);
    }

    @Override
    public List<TestResult> getTestResultsByTestApplication(TestApplication testApp) {
        return service.getTestResultsByTestApplication(testApp);
    }
}
