package br.com.fatecmogidascruzes.saph.controller;

import br.com.fatecmogidascruzes.saph.dao.TestApplicationDAO;
import br.com.fatecmogidascruzes.saph.interfaces.ITestApplicationFacade;

/**
 * All fonts were produced for author's graduation project
 * @date 20/03/2014
 * @author Birche
 */
public class TestApplicationFacade extends AbstractFacade implements ITestApplicationFacade{

    private static TestApplicationFacade facade;
    private TestApplicationDAO dao;
    public static TestApplicationFacade getInstance(){
        if(facade == null){
            facade = new TestApplicationFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private TestApplicationFacade(){
        dao = new TestApplicationDAO();
    }
}
