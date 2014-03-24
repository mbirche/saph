package br.com.fatecmogidascruzes.saph.controller;

import br.com.fatecmogidascruzes.saph.dao.TestResultDAO;
import br.com.fatecmogidascruzes.saph.interfaces.ITestResultFacade;

/**
 * All fonts were produced for author's graduation project
 * @date 24/03/2014
 * @author Birche
 */
public class TestResultFacade extends AbstractFacade implements ITestResultFacade{

    private static TestResultFacade facade;
    private TestResultDAO dao;
    public static TestResultFacade getInstance(){
        if(facade == null){
            facade = new TestResultFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private TestResultFacade(){
        dao = new TestResultDAO();
    }
}
