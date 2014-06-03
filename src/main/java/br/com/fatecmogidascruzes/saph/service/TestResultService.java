/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.service;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.dao.TestResultDAO;
import br.com.fatecmogidascruzes.saph.interfaces.ITestResultService;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import br.com.fatecmogidascruzes.saph.model.TestResult;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class TestResultService extends AbstractService implements ITestResultService{
    
    private static TestResultService service;
    private TestResultDAO dao;
    public static TestResultService getInstance(){
        if(service == null){
            service = new TestResultService();
            return service;
        }else{
            return service;
        }
    }   
    public TestResultService(){
        dao = (TestResultDAO) DAOFactory.getInstance().getDAO(TestResult.class);
    }

    @Override
    public List<TestResult> getTestResultsByStudent(User student) {
        return dao.getTestResultsByStudent(student);
    }

    @Override
    public List<TestResult> getTestResultsByTestApplication(TestApplication testApp) {
        return dao.getTestResultsByTestApplication(testApp);
    }
    
}
